package br.jhonatastomaz.interfaces;

import java.util.Date;
import java.util.List;

public interface IClient {

	 int getId();
	 String getFirstName();
	 String getLastName();
	 String getCompanyName();
	 String getEmail();
	 void setCustomField(String fieldName, String fieldValue);
	 String getCustomField(String fieldName);
	 boolean hasCustomField(String fieldName);
	 IUser getOwner();
	 List<IUser>getUsers();
	 List<IService>getServices();
	 Date getDateCreated();
	 void setDateCreated(Date dateCreated);
	 int getGroupId();
	 void setGroupId(int groupId);
	 String getStatus();
     void setStatus(String status);
	 
}
