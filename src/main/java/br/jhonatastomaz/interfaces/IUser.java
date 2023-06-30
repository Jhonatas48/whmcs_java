package br.jhonatastomaz.interfaces;

public interface IUser {

	 int getId();
	 String getFirstName();
	 String getLastName();
	 String getEmail();
	 void setCustomField(String fieldName, String fieldValue);
	 String getCustomField(String fieldName);
	 boolean hasCustomField(String fieldName);
	
}
