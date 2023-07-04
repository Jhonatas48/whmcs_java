package br.jhonatastomaz.implementations.models;

import java.util.HashMap;
import br.jhonatastomaz.interfaces.IUser;

public class User implements IUser {

	 private int id;
	
	 private String name;
	
	 private String email;
	 
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

	   

}
