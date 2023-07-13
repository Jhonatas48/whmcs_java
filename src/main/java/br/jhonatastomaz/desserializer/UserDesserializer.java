package br.jhonatastomaz.desserializer;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.jhonatastomaz.implementations.models.Client;
import br.jhonatastomaz.implementations.models.User;
import br.jhonatastomaz.interfaces.IClient;
import br.jhonatastomaz.interfaces.IUser;

public class UserDesserializer {
	
	public static IUser deserializeUser(JSONObject jsonObject) {
		 if(jsonObject == null) {
			   return null;
		   }
		 
		 User user = new User();
		 user.setId(jsonObject.getInt("id"));
		 user.setEmail(jsonObject.get("email").toString());
		 user.setName(jsonObject.get("firstname").toString());
		
		 
         return user;
	}

}
