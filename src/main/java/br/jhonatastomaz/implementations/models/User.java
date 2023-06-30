package br.jhonatastomaz.implementations.models;

import java.util.HashMap;
import br.jhonatastomaz.interfaces.IUser;

public class User implements IUser {

	 private int id;
	 private String firstName;
	 private String lastName;
	 private String companyName;
	 private String email;
	 private HashMap<String, String> customFields;
	 
	 public int getId() {
	        return id;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public String getCompanyName() {
	        return companyName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setCustomField(String fieldName, String fieldValue) {
	        customFields.put(fieldName, fieldValue);
	    }

	    public String getCustomField(String fieldName) {
	        return customFields.get(fieldName);
	    }

	    public boolean hasCustomField(String fieldName) {
	        return customFields.containsKey(fieldName);
	    }
	   

}
