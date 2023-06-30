package br.jhonatastomaz.desserializer;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import br.jhonatastomaz.implementations.models.Product;
import br.jhonatastomaz.implementations.models.productsmodels.ProductConfigOption;
import br.jhonatastomaz.implementations.models.productsmodels.ProductCurrency;
import br.jhonatastomaz.implementations.models.productsmodels.ProductCustomField;
import br.jhonatastomaz.implementations.models.productsmodels.ProductPricing;

public class ProductDesserealizer {
	
	  public static Product desserialize( JSONObject jsonObject) {
	        
	        Product product = new Product();
	        product.setPid(jsonObject.optInt("pid"));
	        product.setGid(jsonObject.optInt("gid"));
	        product.setType(jsonObject.optString("type"));
	        product.setName(jsonObject.optString("name"));
	        product.setSlug(jsonObject.optString("slug"));
	        product.setProductUrl(jsonObject.optString("product-url"));
	        product.setDescription(jsonObject.optString("description"));
	        product.setModule(jsonObject.optString("module"));
	        product.setPaytype(jsonObject.optString("paytype"));

	        JSONObject pricingObject = jsonObject.optJSONObject("pricing");
	        if (pricingObject != null) {
	            Map<String, ProductPricing> pricing = new HashMap<String, ProductPricing>();
	            for (String currency : pricingObject.keySet()) {
	                JSONObject priceObject = pricingObject.getJSONObject(currency);
	                ProductPricing price = new ProductPricing();
	                price.setPrefix(priceObject.optString("prefix"));
	                price.setSuffix(priceObject.optString("suffix"));
	                price.setMsetupfee(priceObject.optLong("msetupfee"));
	                price.setQsetupfee(priceObject.optLong("qsetupfee"));
	                price.setSsetupfee(priceObject.optLong("ssetupfee"));
	                price.setAsetupfee(priceObject.optLong("asetupfee"));
	                price.setBsetupfee(priceObject.optLong("bsetupfee"));
	                price.setTsetupfee(priceObject.optLong("tsetupfee"));
	                price.setMonthly(priceObject.optLong("monthly"));
	                price.setQuarterly(priceObject.optLong("quarterly"));
	                price.setSemiannually(priceObject.optLong("semiannually"));
	                price.setAnnually(priceObject.optLong("annually"));
	                price.setBiennially(priceObject.optLong("biennially"));
	                price.setTriennially(priceObject.optLong("triennially"));
	                pricing.put(currency, price);
	            }
	            product.setPricing(pricing);
	        }

	        JSONObject customFieldsObject = jsonObject.optJSONObject("custom-fields");
	        if (customFieldsObject != null) {
	            Map<Integer, ProductCustomField> customFields = new HashMap<>();
	            for (String fieldId : customFieldsObject.keySet()) {
	                JSONObject fieldObject = customFieldsObject.getJSONObject(fieldId);
	                ProductCustomField field = new ProductCustomField();
	                field.setId(Integer.parseInt(fieldId));
	                field.setName(fieldObject.optString("name"));
	                field.setDescription(fieldObject.optString("description"));
	                field.setRequired(fieldObject.optString("required"));
	                customFields.put(Integer.parseInt(fieldId), field);
	            }
	            product.setCustomFields(customFields);
	        }

	        JSONObject configOptionsObject = jsonObject.optJSONObject("config-options");
	        if (configOptionsObject != null) {
	            Map<Integer, ProductConfigOption> configOptions = new HashMap<>();
	            for (String optionId : configOptionsObject.keySet()) {
	                JSONObject optionObject = configOptionsObject.getJSONObject(optionId);
	                ProductConfigOption option = new ProductConfigOption();
	                option.setId(Integer.parseInt(optionId));
	                option.setName(optionObject.optString("name"));
	                option.setType(optionObject.optString("type"));

	                Map<Integer, ProductCurrency> options = new HashMap<>();
	                JSONObject optionsObject = optionObject.optJSONObject("options");
	                if (optionsObject != null) {
	                    for (String optionKey : optionsObject.keySet()) {
	                        JSONObject optionValue = optionsObject.getJSONObject(optionKey);
	                        ProductCurrency optionItem = new ProductCurrency();
	                        optionItem.setId(Integer.parseInt(optionKey));
	                        optionItem.setName(optionValue.optString("name"));
	                        optionItem.setMsetupfee(optionValue.optLong("msetupfee"));
	                        optionItem.setQsetupfee(optionValue.optLong("qsetupfee"));
	                        optionItem.setSsetupfee(optionValue.optLong("ssetupfee"));
	                        optionItem.setAsetupfee(optionValue.optLong("asetupfee"));
	                        optionItem.setBsetupfee(optionValue.optLong("bsetupfee"));
	                        optionItem.setTsetupfee(optionValue.optLong("tsetupfee"));
	                        optionItem.setMonthly(optionValue.optLong("monthly"));
	                        optionItem.setQuarterly(optionValue.optLong("quarterly"));
	                        optionItem.setSemiannually(optionValue.optLong("semiannually"));
	                        optionItem.setAnnually(optionValue.optLong("annually"));
	                        optionItem.setBiennially(optionValue.optLong("biennially"));
	                        optionItem.setTriennially(optionValue.optLong("triennially"));
	                        options.put(Integer.parseInt(optionKey), optionItem);
	                    }
	                }
	                option.setOptions(options);
	                configOptions.put(Integer.parseInt(optionId), option);
	            }
	            product.setConfigOptions(configOptions);
	        }

	        return product;
	    }
}
