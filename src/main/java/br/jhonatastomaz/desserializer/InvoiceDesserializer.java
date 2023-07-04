package br.jhonatastomaz.desserializer;

import org.json.JSONException;
import org.json.JSONObject;

import br.jhonatastomaz.implementations.models.Invoice;
import br.jhonatastomaz.interfaces.IInvoice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InvoiceDesserializer {

    public static IInvoice deserialize(  JSONObject jsonObject) {
    
        try {
        	  Invoice invoice = new Invoice();
        	 invoice.setId(jsonObject.getInt("id"));
             invoice.setUserId(jsonObject.getInt("userid"));
             invoice.setInvoiceNum(jsonObject.getString("invoicenum"));
			 invoice.setDate(parseDate(jsonObject.getString("date")));
			 invoice.setDueDate(parseDate(jsonObject.getString("duedate")));
		     invoice.setDatePaid(parseDate(jsonObject.getString("datepaid")));
		     invoice.setLastCaptureAttempt(parseDate(jsonObject.getString("last_capture_attempt")));
		     invoice.setDateRefunded(parseDate(jsonObject.getString("date_refunded")));
		     invoice.setDateCancelled(parseDate(jsonObject.getString("date_cancelled")));
		     invoice.setSubtotal(jsonObject.getDouble("subtotal"));
		     invoice.setCredit(jsonObject.getDouble("credit"));
		     invoice.setTax(jsonObject.getDouble("tax"));
		     invoice.setTax2(jsonObject.getDouble("tax2"));
		     invoice.setTotal(jsonObject.getDouble("total"));
		     invoice.setTaxRate(jsonObject.getDouble("taxrate"));
		     invoice.setTaxRate2(jsonObject.getDouble("taxrate2"));
	         invoice.setStatus(jsonObject.getString("status"));
             invoice.setPaymentMethod(jsonObject.getString("paymentmethod"));
		     invoice.setPayMethodId(jsonObject.getInt("paymethodid"));
		     invoice.setNotes(jsonObject.getString("notes"));
	         invoice.setCreatedAt(parseDateTime(jsonObject.getString("created_at")));
		     invoice.setUpdatedAt(parseDateTime(jsonObject.getString("updated_at")));
		     invoice.setCurrencyCode(jsonObject.getString("currencycode"));
		     invoice.setCurrencyPrefix(jsonObject.getString("currencyprefix"));
		     invoice.setCurrencySuffix(jsonObject.getString("currencysuffix"));
		     return invoice;
		} catch (JSONException | ParseException e) {
			
			e.printStackTrace();
		}
       
        return null;
       
    }

    private static Date parseDate(String dateString) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(dateString);
    }

    private static Date parseDateTime(String dateTimeString) throws ParseException {
        DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateTimeFormat.parse(dateTimeString);
    }
}
