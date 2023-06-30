package br.jhonatastomaz.implementations.models;

import java.util.Map;

import br.jhonatastomaz.implementations.models.productsmodels.ProductConfigOption;
import br.jhonatastomaz.implementations.models.productsmodels.ProductCustomField;
import br.jhonatastomaz.implementations.models.productsmodels.ProductPricing;
import br.jhonatastomaz.interfaces.IProduct;

public class Product implements IProduct{

	 private int pid;
	    private int gid;
	    private String type;
	    private String name;
	    private String slug;
	    private String productUrl;
	    private String description;
	    private String module;
	    private String paytype;
	    private Map<String, ProductPricing> pricing;
	    private Map<Integer, ProductCustomField> customFields;
	    private Map<Integer, ProductConfigOption> configOptions;

	    public int getPid() {
	        return pid;
	    }

	    public void setPid(int pid) {
	        this.pid = pid;
	    }

	    public int getGid() {
	        return gid;
	    }

	    public void setGid(int gid) {
	        this.gid = gid;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getSlug() {
	        return slug;
	    }

	    public void setSlug(String slug) {
	        this.slug = slug;
	    }

	    public String getProductUrl() {
	        return productUrl;
	    }

	    public void setProductUrl(String productUrl) {
	        this.productUrl = productUrl;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getModule() {
	        return module;
	    }

	    public void setModule(String module) {
	        this.module = module;
	    }

	    public String getPaytype() {
	        return paytype;
	    }

	    public void setPaytype(String paytype) {
	        this.paytype = paytype;
	    }

	    public Map<String, ProductPricing> getPricing() {
	        return pricing;
	    }

	    public void setPricing(Map<String, ProductPricing> pricing) {
	        this.pricing = pricing;
	    }

	    public Map<Integer, ProductCustomField> getCustomFields() {
	        return customFields;
	    }

	    public void setCustomFields(Map<Integer, ProductCustomField> customFields) {
	        this.customFields = customFields;
	    }

	    public Map<Integer, ProductConfigOption> getConfigOptions() {
	        return configOptions;
	    }

	    public void setConfigOptions(Map<Integer, ProductConfigOption> configOptions) {
	        this.configOptions = configOptions;
	    }

}
