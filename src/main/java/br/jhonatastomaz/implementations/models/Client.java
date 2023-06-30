package br.jhonatastomaz.implementations.models;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import br.jhonatastomaz.interfaces.IClient;
import br.jhonatastomaz.interfaces.IService;
import br.jhonatastomaz.interfaces.IUser;

public class Client implements IClient{

	 private int id;
	 private String firstName;
	 private String lastName;
	 private String companyName;
	 private String email;
	 private Date dateCreated;
	 private int groupId;
	 private String status;
	 private HashMap<String, String> customFields;
	 private IUser owner;
	 private List<IUser>users;
	 private List<IService>services;
	 
	 public Client(int id, String firstName, String lastName, String companyName, String email, Date dateCreated, int groupId, String status) {
	        this.id = id;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.companyName = companyName;
	        this.email = email;
	        this.dateCreated = dateCreated;
	        this.groupId = groupId;
	        this.status = status;
	    }
	 
	public Client() {}
	
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

	@Override
	public IUser getOwner() {
		
		return owner;
	}

	@Override
	public List<IUser> getUsers() {
		
		return users;
	}

	@Override
	public List<IService> getServices() {
		
		return services;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
