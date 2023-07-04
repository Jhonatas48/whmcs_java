package br.jhonatastomaz.interfaces;

import java.util.Date;

public interface ITransaction {

	 int getId();
	 void setId(int id);
	 int getUserid();
	 void setUserid(int userid);
	 int getCurrency();
	 void setCurrency(int currency);
	 String getGateway();
	 void setGateway(String gateway);
	 Date getDate();
	 void setDate(Date date);
	 String getDescription();
	 void setDescription(String description);
	 double getAmountIn();
	 void setAmountIn(double amountin);
	 double getFees();
	 void setFees(double fees);
	 double getAmountOut();
	 void setAmountOut(double amountout);
	 String getRate();
	 void setRate(String rate);
	 String getTransid();
	 void setTransid(String transid);
     int getInvoiceid();
     void setInvoiceid(int invoiceid);
	 int getRefundid();
     void setRefundid(int refundid);
}
