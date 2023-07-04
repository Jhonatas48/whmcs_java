package br.jhonatastomaz.implementations.managers;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.jhonatastomaz.desserializer.ClientDesserializer;
import br.jhonatastomaz.implementations.models.Client;
import br.jhonatastomaz.interfaces.IClient;
import br.jhonatastomaz.interfaces.managers.IClientManager;
import me.hwiggy.whmjava.payload.Payload;
import me.hwiggy.whmjava.payload.g.GetClientsDetailsPayload;
import me.hwiggy.whmjava.payload.g.GetClientsPayload;

public class ClientManager implements IClientManager{
	
  private WHMCSApi api;
  
  public ClientManager(WHMCSApi api) {
	
	this.api = api;
	if(api == null) {
		throw new NullPointerException("WhmcsAPi is null");
	}
}
  public List<IClient>getClients(){
	   
		return null;   
	   }
	   
  public IClient getClientByEmail(String email) {
		   return getClient(email, 0); 
	   }
	   
  public IClient getClientById(int id) {
		   return getClient(null, id);
	   }
	   
  public boolean addClient(IClient client) {
	  
	  return false;
  }
  
  public boolean editClient(IClient client) {
	  return false;
  }
  
  private IClient getClient(String email,int id) {
	   
	   if((email == null || email.isEmpty()) && id ==0) {
		   return null;
	   }
	   Payload payload = null;
	   if(id != 0 ) {
		   
		   payload = new GetClientsPayload().withSearch(id+"");
		  
	   }else {
		   payload = new GetClientsPayload().withSearch(email);
	   }
	   
	   try {
			JSONObject json =  api.submitPayload(payload);
			
			if(json == null || !json.get("result").equals("success")) {
				return null;
			}
			
			if(json.getInt("totalresults") ==0) {
				return null;
			}
			JSONObject clientObjects=  json.getJSONObject("clients");
			
			if(clientObjects == null || clientObjects.length() == 0) {
				return null;
			}
			
			JSONArray clientsArray = clientObjects.getJSONArray("client");
			
			if(clientsArray == null|| clientsArray.length() == 0) {
				return null;
			}
			JSONObject clientObject =  clientsArray.getJSONObject(0);
			Client client = ClientDesserializer.deserializeClient(clientObject);
			
			payload = new GetClientsDetailsPayload().withClientID(client.getId());
			
			json = api.submitPayload(payload);
			
			if(json == null || !json.get("result").equals("success")) {
				return null;
			}
			Client clientDetails = ClientDesserializer.deserializeDetailsClient(json);
			clientDetails.setDateCreated(client.getDateCreated());
			clientDetails.setServiceManager(new ServiceManager(api,clientDetails.getId()));
			clientDetails.setInvoiceManager(new InvoiceManager(api, clientDetails.getOwner().getId()));
			return clientDetails;
		} catch (IOException e) {
			
			e.printStackTrace();
			 return null;
		} catch (InterruptedException e) {
		
			e.printStackTrace();
			return null;
		}
//	   return null;
   }

}