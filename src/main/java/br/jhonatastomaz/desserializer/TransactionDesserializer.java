package br.jhonatastomaz.desserializer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import br.jhonatastomaz.implementations.models.Transaction;
import br.jhonatastomaz.interfaces.ITransaction;

public class TransactionDesserializer {

	public static ITransaction deserialize(JSONObject json) {
		if(json == null) {
			return null;
		}
		
		try {
			Transaction transaction = new Transaction();
			transaction.setId(json.getInt("id"));
			transaction.setUserid(json.getInt("userid"));
			transaction.setCurrency(json.getInt("currency"));
			transaction.setGateway(json.getString("gateway"));
			Date date = parseDate(json.getString("date"));
			transaction.setDate(date);
			transaction.setDescription(json.getString("description"));
			transaction.setAmountIn(json.getDouble("amountin"));
			transaction.setFees(json.getDouble("fees"));
			transaction.setAmountOut(json.getDouble("amountout"));
			transaction.setRate(json.getString("rate"));
			transaction.setTransid(json.getString("transid"));
			transaction.setInvoiceid(json.getInt("invoiceid"));
			transaction.setRefundid(json.getInt("refundid"));
			return transaction;
		} catch (JSONException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}
	
	   private static Date parseDate(String dateString) throws ParseException {
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        return dateFormat.parse(dateString);
	    }
}
