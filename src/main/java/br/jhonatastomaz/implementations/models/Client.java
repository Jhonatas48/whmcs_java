package br.jhonatastomaz.implementations.models;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import br.jhonatastomaz.interfaces.IClient;
import br.jhonatastomaz.interfaces.IUser;
import br.jhonatastomaz.interfaces.managers.IInvoiceManager;
import br.jhonatastomaz.interfaces.managers.IServiceManager;

public class Client implements IClient{

	    
	 	private int id;
	 	private String uuid;
	 	private String firstName;
	    private String lastName;
	    private String companyName;
	    private String email;
	    private Date dateCreated;
	    private String fullName;
	    private String address1;
	    private String address2;
	    private String city;
	    private String fullState;
	    private String state;
	    private String postcode;
	    private String countryCode;
	    private String country;
	    private String phoneNumber;
	    private String taxId;
	    private HashMap<String, String> emailPreferences;
	    private String stateCode;
	    private String countryName;
	    private String phoneCC;
	    private String phoneNumberFormatted;
	    private String telephoneNumber;
	    private int billingCID;
	    private String notes;
	    private int currency;
	    private String defaultGateway;
	    private int groupId;
	    private String status;
	    private double credit;
	    private boolean taxExempt;
	    private boolean lateFeeOverride;
	    private boolean overrideDueNotices;
	    private boolean separateInvoices;
	    private boolean disableAutoCC;
	    private boolean emailOptOut;
	    private boolean marketingEmailsOptIn;
	    private boolean overrideAutoClose;
	    private int allowSingleSignOn;
	    private boolean emailVerified;
	    private String language;
	    private boolean isOptedInToMarketingEmails;
	    private String lastLogin;
	    private String currencyCode;
	    private HashMap<Integer, String> customFields;
	    private IUser owner;
	    private List<IUser>users;
	    private IServiceManager serviceManager;
	    private IInvoiceManager invoiceManager;
	 public Client(int id, String firstName, String lastName, String companyName, String email, Date dateCreated, int groupId, String status) {
	        this.id = id;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.companyName = companyName;
	        this.email = email;
	        this.dateCreated = dateCreated;
	        this.groupId = groupId;
	        this.status = status;
	    }
	 
	public Client() {}
	
    public void setCustomField(int fieldid, String fieldValue) {
        customFields.put(fieldid, fieldValue);
    }

    public String getCustomField(int fieldid) {
        return customFields.get(fieldid);
    }

    public boolean hasCustomField(int fieldid) {
        return customFields.containsKey(fieldid);
    }

    

	public IUser getOwner() {
		
		return owner;
	}

	@Override
	public List<IUser> getUsers() {
		
		return users;
	}

	@Override
	public IServiceManager getServiceManager() {
	    
		return serviceManager;
	}
   
	public void setServiceManager(IServiceManager servicemanager) {
		this.serviceManager = servicemanager;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFullState() {
		return fullState;
	}

	public void setFullState(String fullState) {
		this.fullState = fullState;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public HashMap<String, String> getEmailPreferences() {
		return emailPreferences;
	}

	public void setEmailPreferences(HashMap<String, String> emailPreferences) {
		this.emailPreferences = emailPreferences;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getPhoneCC() {
		return phoneCC;
	}

	public void setPhoneCC(String phoneCC) {
		this.phoneCC = phoneCC;
	}

	public String getPhoneNumberFormatted() {
		return phoneNumberFormatted;
	}

	public void setPhoneNumberFormatted(String phoneNumberFormatted) {
		this.phoneNumberFormatted = phoneNumberFormatted;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public int getBillingCID() {
		return billingCID;
	}

	public void setBillingCID(int billingCID) {
		this.billingCID = billingCID;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	public String getDefaultGateway() {
		return defaultGateway;
	}

	public void setDefaultGateway(String defaultGateway) {
		this.defaultGateway = defaultGateway;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public boolean isTaxExempt() {
		return taxExempt;
	}

	public void setTaxExempt(boolean taxExempt) {
		this.taxExempt = taxExempt;
	}

	public boolean isLateFeeOverride() {
		return lateFeeOverride;
	}

	public void setLateFeeOverride(boolean lateFeeOverride) {
		this.lateFeeOverride = lateFeeOverride;
	}

	public boolean isOverrideDueNotices() {
		return overrideDueNotices;
	}

	public void setOverrideDueNotices(boolean overrideDueNotices) {
		this.overrideDueNotices = overrideDueNotices;
	}

	public boolean isSeparateInvoices() {
		return separateInvoices;
	}

	public void setSeparateInvoices(boolean separateInvoices) {
		this.separateInvoices = separateInvoices;
	}

	public boolean isDisableAutoCC() {
		return disableAutoCC;
	}

	public void setDisableAutoCC(boolean disableAutoCC) {
		this.disableAutoCC = disableAutoCC;
	}

	public boolean isEmailOptOut() {
		return emailOptOut;
	}

	public void setEmailOptOut(boolean emailOptOut) {
		this.emailOptOut = emailOptOut;
	}

	public boolean isMarketingEmailsOptIn() {
		return marketingEmailsOptIn;
	}

	public void setMarketingEmailsOptIn(boolean marketingEmailsOptIn) {
		this.marketingEmailsOptIn = marketingEmailsOptIn;
	}

	public boolean isOverrideAutoClose() {
		return overrideAutoClose;
	}

	public void setOverrideAutoClose(boolean overrideAutoClose) {
		this.overrideAutoClose = overrideAutoClose;
	}

	public int getAllowSingleSignOn() {
		return allowSingleSignOn;
	}

	public void setAllowSingleSignOn(int allowSingleSignOn) {
		this.allowSingleSignOn = allowSingleSignOn;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public boolean isOptedInToMarketingEmails() {
		return isOptedInToMarketingEmails;
	}

	public void setOptedInToMarketingEmails(boolean isOptedInToMarketingEmails) {
		this.isOptedInToMarketingEmails = isOptedInToMarketingEmails;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public void setOwner(IUser owner) {
	
		this.owner = owner;
		
	}

	public void setCustomFields(HashMap<Integer, String> customFields) {
		this.customFields = customFields;
	}

	public void setUsers(List<IUser> users) {
		this.users = users;
	}

	public IInvoiceManager getInvoiceManager() {
		return invoiceManager;
	}

	public void setInvoiceManager(IInvoiceManager invoiceManager) {
		this.invoiceManager = invoiceManager;
	}
    
	
	
	
}
