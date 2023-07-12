package br.jhonatastomaz.interfaces;

import java.util.Date;
import java.util.List;

public interface IUser {

	 int getId();
	 String getName();
	 String getEmail();
	 Date getDateCreated();
	 public List<IClient> getClients();

}
