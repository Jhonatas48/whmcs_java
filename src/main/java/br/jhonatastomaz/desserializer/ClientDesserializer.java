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
            String firstName = jsonObject.get("firstname").toString();
            String lastName = jsonObject.get("lastname").toString();
            String companyName = jsonObject.get("companyname").toString();
            String email = jsonObject.get("email").toString();
            Date dateCreated = parseDate(jsonObject.get("datecreated").toString());
            int groupId = jsonObject.getInt("groupid");
            String status = jsonObject.get("status").toString();

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
	        client.setUuid(jsonObject.get("uuid").toString());
	        client.setId(jsonObject.getInt("id"));
	        client.setFirstName(jsonObject.get("firstname").toString());
	        client.setLastName(jsonObject.get("lastname").toString());
	        client.setCompanyName(jsonObject.get("companyname").toString());
	        client.setEmail(jsonObject.get("email").toString());
	        
	        client.setAddress1(jsonObject.get("address1").toString());
	        client.setAddress2(jsonObject.get("address2").toString());
	        client.setCity(jsonObject.get("city").toString());
	        client.setFullState(jsonObject.get("fullstate").toString());
	        client.setState(jsonObject.get("state").toString());
	        client.setPostcode(jsonObject.get("postcode").toString());
	        client.setCountryCode(jsonObject.get("countrycode").toString());
	        client.setCountry(jsonObject.get("country").toString());
	        client.setPhoneNumber(jsonObject.get("phonenumber").toString());
	        client.setTaxId(jsonObject.get("tax_id").toString());
	        client.setEmailPreferences(extractEmailPreferences(emailPreferencesObject));
	        client.setStateCode(jsonObject.get("statecode").toString());
	        client.setCountryName(jsonObject.get("countryname").toString());
	        client.setPhoneCC(jsonObject.get("phonecc").toString());
	        client.setPhoneNumberFormatted(jsonObject.get("phonenumberformatted").toString());
	        client.setTelephoneNumber(jsonObject.get("telephoneNumber").toString());
	        client.setBillingCID(jsonObject.getInt("billingcid"));
	        client.setNotes(jsonObject.get("notes").toString());
	        client.setCurrency(jsonObject.getInt("currency"));
	        client.setCurrencyCode(jsonObject.get("currency_code").toString());
	        client.setDefaultGateway(jsonObject.get("defaultgateway").toString());
	        client.setGroupId(jsonObject.getInt("groupid"));
	        client.setStatus(jsonObject.get("status").toString());
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
	        client.setLanguage(jsonObject.get("language").toString());
	        client.setOptedInToMarketingEmails(jsonObject.getBoolean("isOptedInToMarketingEmails"));
	        client.setLastLogin(jsonObject.get("lastlogin").toString());
	        client.setCustomFields(extractCustomFields(customFieldsArray));

	        List<IUser> userList = new ArrayList<>();
	        for (int i = 0; i < userArray.length(); i++) {
	            JSONObject userObject = userArray.getJSONObject(i);
	            int userId = userObject.getInt("id");
	            String userName = userObject.get("name").toString();
	            String userEmail = userObject.get("email").toString();
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
            if(client.getOwner() == null) {
            	System.out.println("NULO CLID: "+client.getId());
            }
	        return client;
	        
	       }catch (JSONException e) {
			e.printStackTrace();
	       }
	       return null;
	    }

    private static HashMap<String, String> extractEmailPreferences(JSONObject emailPreferencesObject) throws JSONException {
	        HashMap<String, String> emailPreferences = new HashMap<>();
	        emailPreferences.put("general", emailPreferencesObject.get("general").toString());
	        emailPreferences.put("invoice", emailPreferencesObject.get("invoice").toString());
	        emailPreferences.put("support", emailPreferencesObject.get("support").toString());
	        emailPreferences.put("product", emailPreferencesObject.get("product").toString());
	        emailPreferences.put("domain", emailPreferencesObject.get("domain").toString());
	        emailPreferences.put("affiliate", emailPreferencesObject.get("affiliate").toString());
	        return emailPreferences;
	    }
	    
    private static HashMap<Integer, String> extractCustomFields(JSONArray customFieldsArray) throws JSONException {
	        HashMap<Integer, String> customFields = new HashMap<>();
	        for (int i = 0; i < customFieldsArray.length(); i++) {
	            JSONObject customFieldObject = customFieldsArray.getJSONObject(i);
	            int customFieldId = customFieldObject.getInt("id");
	            String customFieldValue = customFieldObject.get("value").toString();
	            customFields.put(customFieldId, customFieldValue);
	        }
	        if(customFields == null ) {
	        	customFields =  new HashMap<>();
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
