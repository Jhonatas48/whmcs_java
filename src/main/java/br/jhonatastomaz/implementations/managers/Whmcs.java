package br.jhonatastomaz.implementations.managers;

import br.jhonatastomaz.interfaces.IClientManager;
import br.jhonatastomaz.interfaces.IWhmcs;

public class Whmcs implements IWhmcs{

	private WHMCSApi api = null;
	
	
	public Whmcs(WHMCSApi api) {
	
		this.api = api;
		if(api == null) {
			throw new NullPointerException("WhmcsAPi is null");
		}
	}


	@Override
	public IClientManager getClientManager() {
	
		return new ClientManager(api);
	}

	
}
