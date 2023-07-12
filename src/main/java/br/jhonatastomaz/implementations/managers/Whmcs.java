package br.jhonatastomaz.implementations.managers;

import br.jhonatastomaz.interfaces.IWhmcs;
import br.jhonatastomaz.interfaces.managers.IClientManager;
import br.jhonatastomaz.interfaces.managers.IInvoiceManager;
import br.jhonatastomaz.interfaces.managers.IUserManager;

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
	
	@Override
	public IInvoiceManager getInvoiceManager() {
		return new InvoiceManager(api);
	}
	
	public IUserManager getUserManager() {
		return new UserManager(api);
	}
	
	
}
