package br.jhonatastomaz.interfaces.details;

import java.util.List;

import br.jhonatastomaz.interfaces.IInvoice;
import br.jhonatastomaz.interfaces.IItemInvoice;
import br.jhonatastomaz.interfaces.ITransaction;

public interface IInvoiceDetails {

	 boolean isCcgateway();
	 void setCcgateway(boolean ccgateway);
	 List<IItemInvoice> getItemsInvoice();
	 void setItemInvoices(List<IItemInvoice> items);
	 List<ITransaction> getTransactions();
	 void setTransactions(List<ITransaction> transactions);
}
