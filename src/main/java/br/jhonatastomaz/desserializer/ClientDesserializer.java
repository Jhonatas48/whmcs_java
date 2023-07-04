package br.jhonatastomaz.desserializer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.jhonatastomaz.implementations.models.Client;
import br.jhonatastomaz.implementations.models.User;
import br.jhonatastomaz.interfaces.IUser;

public class ClientDesserializer {

	public static Client deserializeClient(JSONObject jsonObject) {
		  if(jsonObject == null) {
			   return null;
		   }
		
            int id = jsonObject.getInt("id");
            String firstName = jsonObject.getString("firstname");
            String lastName = jsonObject.getString("lastname");
            String companyName = jsonObject.getString("companyname");
            String email = jsonObject.getString("email");
            Date dateCreated = parseDate(jsonObject.getString("datecreated"));
            int groupId = jsonObject.getInt("groupid");
            String status = jsonObject.getString("status");

            Client client = new Client(id, firstName, lastName, companyName, email, dateCreated, groupId, status);
      
        return client;
    }
	
	public static Client deserializeDetailsClient(JSONObject jsonObject) {
		  
		  if(jsonObject == null) {
			   return null;
		   }
		   
	       try {
	        JSONObject emailPreferencesObject = jsonObject.getJSONObject("email_preferences");
	        JSONArray customFieldsArray = jsonObject.getJSONArray("customfields");
	        JSONArray userArray = jsonObject.getJSONObject("users").getJSONArray("user");

	        Client client = new Client();
	        client.setUuid(jsonObject.getString("uuid"));
	        client.setId(jsonObject.getInt("id"));
	        client.setFirstName(jsonObject.getString("firstname"));
	        client.setLastName(jsonObject.getString("lastname"));
	        client.setCompanyName(jsonObject.getString("companyname"));
	        client.setEmail(jsonObject.getString("email"));
	        
	        client.setAddress1(jsonObject.getString("address1"));
	        client.setAddress2(jsonObject.getString("address2"));
	        client.setCity(jsonObject.getString("city"));
	        client.setFullState(jsonObject.getString("fullstate"));
	        client.setState(jsonObject.getString("state"));
	        client.setPostcode(jsonObject.getString("postcode"));
	        client.setCountryCode(jsonObject.getString("countrycode"));
	        client.setCountry(jsonObject.getString("country"));
	        client.setPhoneNumber(jsonObject.getString("phonenumber"));
	        client.setTaxId(jsonObject.getString("tax_id"));
	        client.setEmailPreferences(extractEmailPreferences(emailPreferencesObject));
	        client.setStateCode(jsonObject.getString("statecode"));
	        client.setCountryName(jsonObject.getString("countryname"));
	        client.setPhoneCC(jsonObject.getString("phonecc"));
	        client.setPhoneNumberFormatted(jsonObject.getString("phonenumberformatted"));
	        client.setTelephoneNumber(jsonObject.getString("telephoneNumber"));
	        client.setBillingCID(jsonObject.getInt("billingcid"));
	        client.setNotes(jsonObject.getString("notes"));
	        client.setCurrency(jsonObject.getInt("currency"));
	        client.setCurrencyCode(jsonObject.getString("currency_code"));
	        client.setDefaultGateway(jsonObject.getString("defaultgateway"));
	        client.setGroupId(jsonObject.getInt("groupid"));
	        client.setStatus(jsonObject.getString("status"));
	        client.setCredit(jsonObject.getDouble("credit"));
	        client.setTaxExempt(jsonObject.getBoolean("taxexempt"));
	        client.setLateFeeOverride(jsonObject.getBoolean("latefeeoveride"));
	        client.setOverrideDueNotices(jsonObject.getBoolean("overideduenotices"));
	        client.setSeparateInvoices(jsonObject.getBoolean("separateinvoices"));
	        client.setDisableAutoCC(jsonObject.getBoolean("disableautocc"));
	        client.setEmailOptOut(jsonObject.getBoolean("emailoptout"));
	        client.setMarketingEmailsOptIn(jsonObject.getBoolean("marketing_emails_opt_in"));
	        client.setOverrideAutoClose(jsonObject.getBoolean("overrideautoclose"));
	        client.setAllowSingleSignOn(jsonObject.getInt("allowSingleSignOn"));
	        client.setEmailVerified(jsonObject.getBoolean("email_verified"));
	        client.setLanguage(jsonObject.getString("language"));
	        client.setOptedInToMarketingEmails(jsonObject.getBoolean("isOptedInToMarketingEmails"));
	        client.setLastLogin(jsonObject.getString("lastlogin"));
	        client.setCustomFields(extractCustomFields(customFieldsArray));

	        List<IUser> userList = new ArrayList<>();
	        for (int i = 0; i < userArray.length(); i++) {
	            JSONObject userObject = userArray.getJSONObject(i);
	            int userId = userObject.getInt("id");
	            String userName = userObject.getString("name");
	            String userEmail = userObject.getString("email");
	            boolean isOwner = userObject.getBoolean("is_owner");
	            User user = new User();
	            user.setId(userId);
	            user.setName(userName);
	            user.setEmail(userEmail);
	            
	            if (isOwner) {
	                client.setOwner(user);
	            }else {
	            	userList.add(user);
	            }
	        }
	        client.setUsers(userList);

	        return client;
	        
	       }catch (JSONException e) {
			e.printStackTrace();
	       }
	       return null;
	    }

    private static HashMap<String, String> extractEmailPreferences(JSONObject emailPreferencesObject) throws JSONException {
	        HashMap<String, String> emailPreferences = new HashMap<>();
	        emailPreferences.put("general", emailPreferencesObject.getString("general"));
	        emailPreferences.put("invoice", emailPreferencesObject.getString("invoice"));
	        emailPreferences.put("support", emailPreferencesObject.getString("support"));
	        emailPreferences.put("product", emailPreferencesObject.getString("product"));
	        emailPreferences.put("domain", emailPreferencesObject.getString("domain"));
	        emailPreferences.put("affiliate", emailPreferencesObject.getString("affiliate"));
	        return emailPreferences;
	    }
	    
    private static HashMap<Integer, String> extractCustomFields(JSONArray customFieldsArray) throws JSONException {
	        HashMap<Integer, String> customFields = new HashMap<>();
	        for (int i = 0; i < customFieldsArray.length(); i++) {
	            JSONObject customFieldObject = customFieldsArray.getJSONObject(i);
	            int customFieldId = customFieldObject.getInt("id");
	            String customFieldValue = customFieldObject.getString("value");
	            customFields.put(customFieldId, customFieldValue);
	        }
	        return customFields;
	    }

	private static Date parseDate(String dateString) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
