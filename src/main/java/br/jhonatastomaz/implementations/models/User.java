package br.jhonatastomaz.implementations.models;

import java.util.Date;
import java.util.List;

import br.jhonatastomaz.interfaces.IClient;
import br.jhonatastomaz.interfaces.IUser;

public class User implements IUser {

	 private int id;
	
	 private String name;
	
	 private String email;
	 
	 private Date datecreated;
	 
	 private List<IClient>clients;
	 
	 public User(int id, String name, String email) {
	        this.id = id;
	        this.name=name;
	        this.email = email;
	      
	    }

	 public User() {
		 
	 }
	 
	 public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int getId() {
	        return id;
	}

	 public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getName() {
		
		return name;
	}

	@Override
	public String getEmail() {
	
		return email;
	}

	@Override
	public Date getDateCreated() {
		
		return datecreated;
	}
	
	public void setDateCreated(Date datecreated) {
		this.datecreated = datecreated;
	}
	
	@Override
	public List<IClient> getClients() {
		return clients;
	}

	public void setClients(List<IClient> clients) {
		this.clients = clients;
	}


}
