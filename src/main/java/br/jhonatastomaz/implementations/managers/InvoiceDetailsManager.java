package br.jhonatastomaz.implementations.managers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.jhonatastomaz.desserializer.TransactionDesserializer;
import br.jhonatastomaz.implementations.models.ItemInvoice;
import br.jhonatastomaz.implementations.models.validations.Checkers;
import br.jhonatastomaz.interfaces.IItemInvoice;
import br.jhonatastomaz.interfaces.ITransaction;
import br.jhonatastomaz.interfaces.details.IInvoiceDetails;
import me.hwiggy.whmjava.payload.Payload;
import me.hwiggy.whmjava.payload.g.GetInvoicePayload;

class InvoiceDetailsManager implements IInvoiceDetails{
	
	    private WHMCSApi api;
	    private int invoiceId;
	    private boolean ccgateway;
	    private List<IItemInvoice> items;
	    private List<ITransaction> transactions;

	    public InvoiceDetailsManager(WHMCSApi api,int invoiceId) {
	    	this.api=api;
	    	this.invoiceId=invoiceId;
	    	this.api=api;
			if(api == null) {
				throw new NullPointerException("WhmcsAPi is null");
			}
			if(invoiceId ==0) {
				throw new IllegalArgumentException("InvoiceId is 0");
			}
	    }
	    public boolean isCcgateway() {
	    	loadInvoiceDetails();
	        return ccgateway;
	    }

	    public void setCcgateway(boolean ccgateway) {
	        this.ccgateway = ccgateway;
	    }

	    public List<IItemInvoice> getItems() {
	    	loadInvoiceDetails();
	        return items;
	    }

	    public void setItems(List<IItemInvoice> items) {
	        this.items = items;
	    }

	    public List<ITransaction> getTransactions() {
	    	loadInvoiceDetails();
	    	return transactions;
	    }

	    public void setTransactions(List<ITransaction> transactions) {
	        this.transactions = transactions;
	    }

		@Override
		public List<IItemInvoice> getItemsInvoice() {
			loadInvoiceDetails();
			return items;
		}

		@Override
		public void setItemInvoices(List<IItemInvoice> items) {
			this.items = items;
			
		}
        
		private void loadInvoiceDetails() {
			
			Payload payload = new GetInvoicePayload(invoiceId);
			try {
				
				JSONObject json = api.submitPayload(payload);
				if(json == null || !json.get("result").equals("success")) {
					return;
				}
				
				
				this.ccgateway = json.getBoolean("ccgateway");
				
				JSONObject itemsObjects=  json.getJSONObject("items");
				
				if(itemsObjects == null || itemsObjects.length() == 0) {
					this.items=null;
					return;
				}
				
				JSONArray itemsArray = itemsObjects.getJSONArray("item");
				
				if(itemsArray == null|| itemsArray.length() == 0) {
					this.items=null;
					return;
				}
				int lenght = itemsArray.length();
				List<IItemInvoice>itens = new ArrayList<>();
				
				for(int id=0;id<lenght;id++) {
					JSONObject itemObject = itemsArray.getJSONObject(id);
					
					// Atribuir os valores do JSON aos atributos de InvoiceItem
					ItemInvoice itemDetails = new ItemInvoice();
					
				    itemDetails.setId(itemObject.getInt("id"));
				    itemDetails.setType(itemObject.getString("type"));
				    itemDetails.setRelid(itemObject.getInt("relid"));
				    itemDetails.setDescription(itemObject.getString("description"));
				    itemDetails.setAmount(itemObject.getDouble("amount"));
				    itemDetails.setTaxed(itemObject.getInt("taxed"));
				    itens.add(itemDetails);
				    
				}
				this.items= itens;
				
				if (!json.has("transactions") || Checkers.isEmpty(json.get("transactions").toString())) {
				    return;
				}

				JSONObject transactionsObject = json.getJSONObject("transactions");
				if (!transactionsObject.has("transaction")) {
				    return;
				}

				JSONArray transactionsArray = transactionsObject.getJSONArray("transaction");
				int length = transactionsArray.length();

				List<ITransaction> transactions = new ArrayList<>();
				for (int i = 0; i < length; i++) {
				    JSONObject transactionObject = transactionsArray.getJSONObject(i);
				    ITransaction transaction = TransactionDesserializer.deserialize(transactionObject);
				    transactions.add(transaction);
				}

				this.transactions = transactions;
				
				
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
