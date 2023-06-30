package br.jhonatastomaz.desserializer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

import br.jhonatastomaz.implementations.models.Client;

public class ClientDesserializer {

	public static Client deserializeClients(JSONObject jsonObject) {
     
            int id = jsonObject.getInt("id");
            String firstName = jsonObject.getString("firstname");
            String lastName = jsonObject.getString("lastname");
            String companyName = jsonObject.getString("companyname");
            String email = jsonObject.getString("email");
            Date dateCreated = parseDate(jsonObject.getString("datecreated"));
            int groupId = jsonObject.getInt("groupid");
            String status = jsonObject.getString("status");

            Client client = new Client(id, firstName, lastName, companyName, email, dateCreated, groupId, status);
            
      

        return client;
    }
	
	private static Date parseDate(String dateString) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
