package br.jhonatastomaz.interfaces;

import java.util.Date;

import br.jhonatastomaz.interfaces.details.IInvoiceDetails;

public interface IInvoice {

	 int getId();
	 int getUserId();
	 String getInvoiceNum();
	 Date getDate();
	 Date getDueDate();
	 Date getDatePaid();
	 Date getLastCaptureAttempt();
	 Date getDateRefunded();
	 Date getDateCancelled();
	 double getSubtotal();
	 double getCredit();
	 double getTax();
	 double getTax2();
	 double getTotal();
	 double getTaxRate();
	 double getTaxRate2();
	 String getStatus();
	 String getPaymentMethod();
	 String getPayMethodId();
	 String getNotes();
	 Date getCreatedAt();
	 Date getUpdatedAt();
	 String getCurrencyCode();
	 String getCurrencyPrefix();
	 String getCurrencySuffix();
	 IInvoiceDetails getInvoiceDetails();
	 public IUser getUser();
}
