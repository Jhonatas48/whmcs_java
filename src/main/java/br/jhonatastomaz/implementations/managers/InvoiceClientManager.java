package br.jhonatastomaz.implementations.managers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.jhonatastomaz.desserializer.InvoiceDesserializer;
import br.jhonatastomaz.interfaces.IInvoice;
import br.jhonatastomaz.interfaces.IInvoiceManager;
import me.hwiggy.whmjava.payload.Payload;
import me.hwiggy.whmjava.payload.g.GetInvoicesPayload;

public class InvoiceClientManager implements IInvoiceManager{

	private WHMCSApi api;
    private int userId;
	
	public InvoiceClientManager(WHMCSApi api,int userid) {
		this.api=api;
		this.userId=userid;
		if(api == null) {
			throw new NullPointerException("WhmcsAPi is null");
		}
		if(userId ==0) {
			throw new IllegalArgumentException("UserId is 0");
		}
	}
	public InvoiceClientManager(WHMCSApi api) {
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
		
		
		try {
			JSONObject json = api.submitPayload(payload);
			
			if(json == null || !json.get("result").equals("success")) {
				return null;
			}
			
			if(json.getInt("totalresults") ==0) {
				return null;
			}
			
			if(json.getInt("numreturned") < json.getInt("totalresults")) {
			    payload.accumulate("limitnum",json.get("limitnum"));
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
				IInvoice invoice = InvoiceDesserializer.deserialize(invoiceObject);
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
