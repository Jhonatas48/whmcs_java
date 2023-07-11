package br.jhonatastomaz.interfaces;

import br.jhonatastomaz.interfaces.managers.IClientManager;
import br.jhonatastomaz.interfaces.managers.IInvoiceManager;

public interface IWhmcs {

	public IClientManager getClientManager();
	public IInvoiceManager getInvoiceManager();
	
}
