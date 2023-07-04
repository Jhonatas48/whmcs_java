package br.jhonatastomaz.interfaces;

import java.util.List;

public interface IClientManager {

	public List<IClient>getClients();
	public IClient getClientByEmail(String email);
	public IClient getClientById(int id);
	public boolean addClient(IClient client);
	public boolean editClient(IClient client);
}
