/**
 * 
 */
package br.jhonatastomaz.implementations.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;

import br.jhonatastomaz.desserializer.UserDesserializer;
import br.jhonatastomaz.implementations.models.validations.Checkers;
import br.jhonatastomaz.interfaces.IUser;
import br.jhonatastomaz.interfaces.managers.IUserManager;
import me.hwiggy.whmjava.payload.Payload;
import me.hwiggy.whmjava.payload.g.GetUsersPayload;

/**
 * 
 */
public class UserManager implements IUserManager {

	private WHMCSApi api;
	public UserManager(WHMCSApi api) {
		this.api = api;
	}
	@Override
	public List<IUser> getUsers() {
		Payload payload = new GetUsersPayload();
		return performGetUsers(payload);
	}

	@Override
	public IUser getUserByEmail(String email) {
		
		Payload payload = new GetUsersPayload().search(email);
		List<IUser>users =  performGetUsers(payload);
		
		if(Checkers.isListEmpty(users)) {
			return null;
		}
		
		return users.get(0);
	}

	@Override
	public IUser getUserById(int id) {
		
        List<IUser>users =  getUsers();
        
        if(Checkers.isListEmpty(users)) {
			return null;
		}
        Optional<IUser>userObject = users.stream().filter(user-> user.getId() == id).findFirst();
        
        try {
        	
        	return userObject.get();
        	
        }catch (Exception e) {
		
        	return null;
		}
        
	}
    
	private List<IUser>performGetUsers(Payload payload){
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
				
				JSONArray usersArray = json.getJSONArray("users");
				
				if(usersArray == null|| usersArray.length() == 0) {
					return null;
				}
				
				int lenght = usersArray.length();
				
	            List<IUser>users = new ArrayList<>();
	            for(int id=0;id<lenght;id++) {
	  			  JSONObject userObject = usersArray.getJSONObject(id);
	  			   IUser user = UserDesserializer.deserializeUser(userObject);
	  			   users.add(user);
	  			 }
	            
	            return users;
	            
		   }catch (Exception e) {
			   e.printStackTrace();
			   //return null;
		   }
		   return null;
   }
}
