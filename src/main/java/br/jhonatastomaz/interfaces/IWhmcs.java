package br.jhonatastomaz.interfaces;

import br.jhonatastomaz.interfaces.managers.IClientManager;
import br.jhonatastomaz.interfaces.managers.IInvoiceManager;
import br.jhonatastomaz.interfaces.managers.IUserManager;

public interface IWhmcs {

	public IClientManager getClientManager();
	public IInvoiceManager getInvoiceManager();
	public IUserManager getUserManager();
	
}
