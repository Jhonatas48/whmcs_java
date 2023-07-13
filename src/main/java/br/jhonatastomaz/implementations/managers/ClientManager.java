package br.jhonatastomaz.implementations.managers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;

import br.jhonatastomaz.desserializer.ClientDesserializer;
import br.jhonatastomaz.implementations.models.Client;
import br.jhonatastomaz.implementations.models.validations.Checkers;
import br.jhonatastomaz.interfaces.IClient;
import br.jhonatastomaz.interfaces.managers.IClientManager;
import me.hwiggy.whmjava.payload.Payload;
import me.hwiggy.whmjava.payload.g.GetClientsDetailsPayload;
import me.hwiggy.whmjava.payload.g.GetClientsPayload;

class ClientManager implements IClientManager{
	
  private WHMCSApi api;
  
  public ClientManager(WHMCSApi api) {
	
	this.api = api;
	if(api == null) {
		throw new NullPointerException("WhmcsAPi is null");
	}
}
  private List<IClient>clients = new ArrayList<>();
  public List<IClient>getClients(){
	    Payload payload = new GetClientsPayload();
	    clients = getClients(payload);
	    if(Checkers.isListEmpty(clients)) {
	    	clients = new ArrayList<>();
	    }
	    
		return clients; 
	   }
	   
  public IClient getClientByEmail(String email) {
	       
	      if(Checkers.isEmpty(email)) {
	    	   return null;
	       }
	      IClient clientRetrieve =findClientByEmail(email);
	      
	      if(!Checkers.isObjectNull(clientRetrieve)) {
	    	  return clientRetrieve;
	      }
	       
	       Payload payload = new GetClientsPayload().withSearch(email);
	       List<IClient>clientRetrieves=  getClients(payload);
		   if(Checkers.isListEmpty(clientRetrieves)) {
			   return null;
		   }
		   clients.add(clientRetrieves.get(0));
		  //clients= clientRetrieves;
		   
		   return clientRetrieves.get(0);
			
			
	   }
  public IClient getClientByUserId(int id) {
      
      
	  Checkers.validadeLongPositive(id+"", "id");
      IClient clientRetrieve =findClientByUserId(id);
      
      if(!Checkers.isObjectNull(clientRetrieve)) {
    	  return clientRetrieve;
      }
       
       List<IClient>clientRetrieves=  getClients();
	   if(Checkers.isListEmpty(clientRetrieves)) {
		   return null;
	   }
	   
	  clients= clientRetrieves;
	  clientRetrieve =findClientByUserId(id);
	   return clientRetrieves.get(0);
		
		
   }
  
  
  public IClient getClientById(int id) {
      
      
	  Checkers.validadeLongPositive(id+"", "id");
      IClient clientRetrieve =findClientById(id);
      
      if(!Checkers.isObjectNull(clientRetrieve)) {
    	  return clientRetrieve;
      }
     
       List<IClient>clientRetrieves=  getClients();
	   if(Checkers.isListEmpty(clientRetrieves)) {
		   return null;
	   }
	   
	  clients= clientRetrieves;
	  clientRetrieve =findClientById(id);
	   return clientRetrieve;
		
		
   }

  
  public boolean addClient(IClient client) {
	 
	  return false;
  }
  
  public boolean editClient(IClient client) {
	  return false;
  }
  
  private List<IClient> getClients(Payload payload) {
	  
	   Checkers.validadeObjectNotNull(payload,"payload");
	   try {
			JSONObject json =  api.submitPayload(payload);
			
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
			JSONObject clientObjects=  json.getJSONObject("clients");
			
			if(clientObjects == null || clientObjects.length() == 0) {
				return null;
			}
			
			JSONArray clientsArray = clientObjects.getJSONArray("client");
			
			if(clientsArray == null|| clientsArray.length() == 0) {
				return null;
			}
			
			int lenght = clientsArray.length();
			
            List<IClient>clients = new ArrayList<>();
			
			for(int id=0;id<lenght;id++) {
			  JSONObject clientObject = clientsArray.getJSONObject(id);
			  Client client = ClientDesserializer.deserializeClient(clientObject);
			  payload = new GetClientsDetailsPayload().withClientID(client.getId());
			    json = api.submitPayload(payload);

				if(json == null || !json.get("result").equals("success")) {
					return null;
				}
				
				Client clientDetails = ClientDesserializer.deserializeDetailsClient(json);
				clientDetails.setDateCreated(client.getDateCreated());
			
			  clientDetails.setServiceManager(new ServiceManager(api,client.getId()));
			  clientDetails.setInvoiceManager(new InvoiceManager(api, clientDetails.getId()));
			  clients.add(clientDetails);
			}
		
			return clients;
		} catch (IOException e) {
			
			e.printStackTrace();
			 return null;
		} catch (InterruptedException e) {
		
			e.printStackTrace();
			return null;
		}
//	   return null;
   }

  
  private IClient findClientByEmail(String email) {
		
		  Optional<IClient>clientObject = clients.stream().filter(client -> client.getEmail().equalsIgnoreCase(email)).findFirst();
	        
	        try {
	        	
	        	return clientObject.get();
	        	
	        }catch (Exception e) {
			
	        	
	        	return null;
			}
	
  }

  private IClient findClientByUserId(int userId) {
		
	  Optional<IClient>clientObject = clients.stream().filter(client -> client.getOwner().getId() == userId).findFirst();
        
        try {
        	
        	return clientObject.get();
        	
        }catch (Exception e) {
		
        	
        	return null;
		}

}
  
 private IClient findClientById(int userId) {
	  
	  Optional<IClient>clientObject = clients.stream().filter(client -> client.getId() == userId).findFirst();
        
        try {
        	
        	return clientObject.get();
        	
        }catch (Exception e) {
		
        	
        	return null;
		}

}

}