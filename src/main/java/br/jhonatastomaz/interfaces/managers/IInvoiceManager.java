package br.jhonatastomaz.interfaces.managers;

import java.util.List;

import br.jhonatastomaz.implementations.models.enums.InvoiceStatus;
import br.jhonatastomaz.interfaces.IInvoice;

public interface IInvoiceManager {

	public List<IInvoice>getInvoices();
	public List<IInvoice>getInvoicesByStatus(InvoiceStatus status);
	public IInvoice getInvoice(int invoiceId);
}
