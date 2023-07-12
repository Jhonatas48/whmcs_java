package br.jhonatastomaz.implementations.managers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

import br.jhonatastomaz.desserializer.InvoiceDesserializer;
import br.jhonatastomaz.implementations.models.Invoice;
import br.jhonatastomaz.implementations.models.enums.InvoiceStatus;
import br.jhonatastomaz.implementations.models.validations.Checkers;
import br.jhonatastomaz.interfaces.IInvoice;
import br.jhonatastomaz.interfaces.IUser;
import br.jhonatastomaz.interfaces.managers.IInvoiceManager;
import me.hwiggy.whmjava.payload.Payload;
import me.hwiggy.whmjava.payload.g.GetInvoicesPayload;

public class InvoiceManager implements IInvoiceManager{

	private WHMCSApi api;
    private int userId;
	
	public InvoiceManager(WHMCSApi api,int userid) {
		this.api=api;
		this.userId=userid;
		if(api == null) {
			throw new NullPointerException("WhmcsAPi is null");
		}
		if(userId ==0) {
			throw new IllegalArgumentException("UserId is 0");
		}
	}
	public InvoiceManager(WHMCSApi api) {
		this.api=api;
		if(api == null) {
			throw new NullPointerException("WhmcsAPi is null");
		}
	}
	
	@Override
	public List<IInvoice> getInvoices() {
		
		Payload payload = null;
		
		if(userId == 0) {
			payload = new GetInvoicesPayload();
		}
		else {
			payload = new GetInvoicesPayload().withUserid(userId);
		}
		
		
		return performGetInvoices(payload);
	}
	
	@Override
	public List<IInvoice> getInvoicesByStatus(InvoiceStatus status) {
		
		if(status == null) {
			status = status.Unpaid;
		}
		
        Payload payload = null;
		
		if(userId == 0) {
			payload = new GetInvoicesPayload().withStatus(status.toString());
		}
		else {
			payload = new GetInvoicesPayload().withUserid(userId).withStatus(status.toString());
		}
		
		return performGetInvoices(payload);
	}
	
	@Override
	public IInvoice getInvoice(int invoiceId) {
		 Payload payload = null;
			
		 if(userId == 0) {
			payload = new GetInvoicesPayload();
		 }
		 else {
			payload = new GetInvoicesPayload().withUserid(userId);
		 }
			
		 List<IInvoice> invoices =performGetInvoices(payload);
		 
		 if(Checkers.isListEmpty(invoices)) {
			 return null;
		 }
		 
		 List<IInvoice>invoicefounds= invoices.stream().filter(invoice -> invoice.getId() ==invoiceId).collect(Collectors.toList());
		 if(Checkers.isListEmpty(invoicefounds)) {
			 return null;
		 }
		 
		 return invoicefounds.get(0);
	}

	private List<IInvoice> performGetInvoices(Payload payload) {
		
		if(payload == null) {
			throw new NullPointerException("Payload GetInvoices is required");
		}
		
		try {
			JSONObject json = api.submitPayload(payload);
			
			if(json == null || !json.get("result").equals("success")) {
				return null;
			}
			
			if(json.getInt("totalresults") ==0) {
				return null;
			}
			
			if(json.getInt("numreturned") < json.getInt("totalresults")) {
			    payload.accumulate("limitnum",json.get("totalresults"));
			    json = api.submitPayload(payload);
			}
			JSONObject invoicesObjects=  json.getJSONObject("invoices");
			
			if(invoicesObjects == null || invoicesObjects.length() == 0) {
				return null;
			}
			
			JSONArray invoicesArray = invoicesObjects.getJSONArray("invoice");
			
			if(invoicesArray == null|| invoicesArray.length() == 0) {
				return null;
			}
			
			int lenght = invoicesArray.length();
			List<IInvoice>invoices = new ArrayList<>();
			
			for(int id=0;id<lenght;id++) {
				JSONObject invoiceObject = invoicesArray.getJSONObject(id);
				Invoice  invoice = (Invoice) InvoiceDesserializer.deserialize(invoiceObject);
				invoice.setInvoiceDetails(new InvoiceDetailsManager(api,invoice.getId()));
				UserManager userManager = new UserManager(api);
		        IUser user = userManager.getUserById(invoice.getUserId());
		        invoice.setUser(user);
				invoices.add(invoice);
		        
				
			}
			
			return invoices;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	  
}
