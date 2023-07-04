package br.jhonatastomaz.interfaces;

import java.util.Date;
import java.util.List;

public interface IClient {

	 int getId();
	 String getFirstName();
	 String getLastName();
	 String getCompanyName();
	 String getEmail();
	 void setCustomField(int fieldid, String fieldValue);
	 String getCustomField(int fieldid);
	 boolean hasCustomField(int fieldid);
	 IUser getOwner();
	 List<IUser>getUsers();
	 IServiceManager getServiceManager();
	 Date getDateCreated();
	 void setDateCreated(Date dateCreated);
	 int getGroupId();
	 void setGroupId(int groupId);
	 String getStatus();
     void setStatus(String status);
	 
}
