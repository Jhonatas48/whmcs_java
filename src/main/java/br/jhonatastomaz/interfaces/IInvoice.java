package br.jhonatastomaz.interfaces;

import java.math.BigDecimal;
import java.util.Date;

public interface IInvoice {

	 int getId();
	 int getClientId();
	 Date getDate();
	 BigDecimal getTotalAmount();
}
