package br.jhonatastomaz.desserializer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.jhonatastomaz.implementations.models.ConfigOption;
import br.jhonatastomaz.implementations.models.CustomField;
import br.jhonatastomaz.implementations.models.Service;

public class ServiceDesserializer {
	
	public static Service deserializeService(JSONObject jsonObject) {
      
            int id = jsonObject.getInt("id");
            int clientId = jsonObject.getInt("clientid");
            int orderId = jsonObject.getInt("orderid");
            String orderNumber = jsonObject.get("ordernumber").toString();
            int pid = jsonObject.getInt("pid");
            Date regDate = parseDate(jsonObject.getString("regdate"));
            String name = jsonObject.getString("name");
            String translatedName = jsonObject.getString("translated_name");
            String groupName = jsonObject.getString("groupname");
            String translatedGroupName = jsonObject.getString("translated_groupname");
            String domain = jsonObject.getString("domain");
            String dedicatedIp = jsonObject.getString("dedicatedip");
            int serverId = jsonObject.getInt("serverid");
            String serverName = jsonObject.getString("servername");
            String serverIp = jsonObject.get("serverip").toString();
            String serverHostname = jsonObject.get("serverhostname").toString();
            String suspensionReason = jsonObject.getString("suspensionreason");
            double firstPaymentAmount = jsonObject.getDouble("firstpaymentamount");
            double recurringAmount = jsonObject.getDouble("recurringamount");
            String paymentMethod = jsonObject.getString("paymentmethod");
            String paymentMethodName = jsonObject.getString("paymentmethodname");
            String billingCycle = jsonObject.getString("billingcycle");
            Date nextDueDate = parseDate(jsonObject.getString("nextduedate"));
            String status = jsonObject.getString("status");
            String username = jsonObject.getString("username");
            String password = jsonObject.getString("password");
            String subscriptionId = jsonObject.getString("subscriptionid");
            int promoId = jsonObject.getInt("promoid");
            String overideAutoSuspend = jsonObject.get("overideautosuspend").toString();
            Date overideSuspendUntil = parseDate(jsonObject.getString("overidesuspenduntil"));
            String ns1 = jsonObject.getString("ns1");
            String ns2 = jsonObject.getString("ns2");
            String assignedIps = jsonObject.getString("assignedips");
            String notes = jsonObject.getString("notes");
            int diskUsage = jsonObject.getInt("diskusage");
            int diskLimit = jsonObject.getInt("disklimit");
            int bwUsage = jsonObject.getInt("bwusage");
            int bwLimit = jsonObject.getInt("bwlimit");
            Date lastUpdate = parseDate(jsonObject.getString("lastupdate"));

            List<CustomField> customFields = new ArrayList<>();
            JSONObject customFieldsObject = jsonObject.getJSONObject("customfields");
            if (customFieldsObject.has("customfield")) {
                JSONArray customFieldsArray = customFieldsObject.getJSONArray("customfield");
                for (int j = 0; j < customFieldsArray.length(); j++) {
                    JSONObject customFieldObject = customFieldsArray.getJSONObject(j);
                    int customFieldId = customFieldObject.getInt("id");
                    String customFieldName = customFieldObject.getString("name");
                    String translatedCustomFieldName = customFieldObject.getString("translated_name");
                    String customFieldValue = customFieldObject.getString("value");
                    CustomField customField = new CustomField(customFieldId, customFieldName, translatedCustomFieldName, customFieldValue);
                    customFields.add(customField);
                }
            }

            List<ConfigOption> configOptions = new ArrayList<>();
            JSONObject configOptionsObject = jsonObject.getJSONObject("configoptions");
            if (configOptionsObject.has("configoption")) {
                JSONArray configOptionsArray = configOptionsObject.getJSONArray("configoption");
                for (int j = 0; j < configOptionsArray.length(); j++) {
                    JSONObject configOptionObject = configOptionsArray.getJSONObject(j);
                    int configOptionId = configOptionObject.getInt("id");
                    String configOptionName = configOptionObject.getString("option");
                    String configOptionType = configOptionObject.getString("type");
                    String configOptionValue = configOptionObject.getString("value");
                    ConfigOption configOption = new ConfigOption(configOptionId, configOptionName, configOptionType, configOptionValue);
                    configOptions.add(configOption);
                }
            }

            Service service = new Service(id, clientId, orderId, orderNumber, pid, regDate, name, translatedName, groupName, translatedGroupName, domain, dedicatedIp, serverId, serverName, serverIp, serverHostname, suspensionReason, firstPaymentAmount, recurringAmount, paymentMethod, paymentMethodName, billingCycle, nextDueDate, status, username, password, subscriptionId, promoId, overideAutoSuspend, overideSuspendUntil, ns1, ns2, assignedIps, notes, diskUsage, diskLimit, bwUsage, bwLimit, lastUpdate, customFields, configOptions);
           
        

        return service;
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
