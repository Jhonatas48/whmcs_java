package br.jhonatastomaz.implementations.models;

import java.util.Date;
import java.util.List;

import br.jhonatastomaz.interfaces.IService;
import br.jhonatastomaz.interfaces.managers.IServiceManager;

public class Service implements IService{

	private int id;
    private int clientId;
    private int orderId;
    private String orderNumber;
    private int pid;
    private Date regDate;
    private String name;
    private String translatedName;
    private String groupName;
    private String translatedGroupName;
    private String domain;
    private String dedicatedIp;
    private int serverId;
    private String serverName;
    private String serverIp;
    private String serverHostname;
    private String suspensionReason;
    private double firstPaymentAmount;
    private double recurringAmount;
    private String paymentMethod;
    private String paymentMethodName;
    private String billingCycle;
    private Date nextDueDate;
    private String status;
    private String username;
    private String password;
    private String subscriptionId;
    private int promoId;
    private String overideAutoSuspend;
    private Date overideSuspendUntil;
    private String ns1;
    private String ns2;
    private String assignedIps;
    private String notes;
    private int diskUsage;
    private int diskLimit;
    private int bwUsage;
    private int bwLimit;
    private Date lastUpdate;
    private List<CustomField> customFields;
    private List<ConfigOption> configOptions;
    
    public Service() {
    	
    }
    
    public Service(int id, int clientId, int orderId, String orderNumber, int pid, Date regDate, String name, String translatedName, String groupName, String translatedGroupName, String domain, String dedicatedIp, int serverId, String serverName, String serverIp, String serverHostname, String suspensionReason, double firstPaymentAmount, double recurringAmount, String paymentMethod, String paymentMethodName, String billingCycle, Date nextDueDate, String status, String username, String password, String subscriptionId, int promoId, String overideAutoSuspend, Date overideSuspendUntil, String ns1, String ns2, String assignedIps, String notes, int diskUsage, int diskLimit, int bwUsage, int bwLimit, Date lastUpdate, List<CustomField> customFields, List<ConfigOption> configOptions) {
        this.id = id;
        this.clientId = clientId;
        this.orderId = orderId;
        this.orderNumber = orderNumber;
        this.pid = pid;
        this.regDate = regDate;
        this.name = name;
        this.translatedName = translatedName;
        this.groupName = groupName;
        this.translatedGroupName = translatedGroupName;
        this.domain = domain;
        this.dedicatedIp = dedicatedIp;
        this.serverId = serverId;
        this.serverName = serverName;
        this.serverIp = serverIp;
        this.serverHostname = serverHostname;
        this.suspensionReason = suspensionReason;
        this.firstPaymentAmount = firstPaymentAmount;
        this.recurringAmount = recurringAmount;
        this.paymentMethod = paymentMethod;
        this.paymentMethodName = paymentMethodName;
        this.billingCycle = billingCycle;
        this.nextDueDate = nextDueDate;
        this.status = status;
        this.username = username;
        this.password = password;
        this.subscriptionId = subscriptionId;
        this.promoId = promoId;
        this.overideAutoSuspend = overideAutoSuspend;
        this.overideSuspendUntil = overideSuspendUntil;
        this.ns1 = ns1;
        this.ns2 = ns2;
        this.assignedIps = assignedIps;
        this.notes = notes;
        this.diskUsage = diskUsage;
        this.diskLimit = diskLimit;
        this.bwUsage = bwUsage;
        this.bwLimit = bwLimit;
        this.lastUpdate = lastUpdate;
        this.customFields = customFields;
        this.configOptions = configOptions;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTranslatedName() {
		return translatedName;
	}
	public void setTranslatedName(String translatedName) {
		this.translatedName = translatedName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getTranslatedGroupName() {
		return translatedGroupName;
	}
	public void setTranslatedGroupName(String translatedGroupName) {
		this.translatedGroupName = translatedGroupName;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getDedicatedIp() {
		return dedicatedIp;
	}
	public void setDedicatedIp(String dedicatedIp) {
		this.dedicatedIp = dedicatedIp;
	}
	public int getServerId() {
		return serverId;
	}
	public void setServerId(int serverId) {
		this.serverId = serverId;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getServerIp() {
		return serverIp;
	}
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	public String getServerHostname() {
		return serverHostname;
	}
	public void setServerHostname(String serverHostname) {
		this.serverHostname = serverHostname;
	}
	public String getSuspensionReason() {
		return suspensionReason;
	}
	public void setSuspensionReason(String suspensionReason) {
		this.suspensionReason = suspensionReason;
	}
	public double getFirstPaymentAmount() {
		return firstPaymentAmount;
	}
	public void setFirstPaymentAmount(double firstPaymentAmount) {
		this.firstPaymentAmount = firstPaymentAmount;
	}
	public double getRecurringAmount() {
		return recurringAmount;
	}
	public void setRecurringAmount(double recurringAmount) {
		this.recurringAmount = recurringAmount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentMethodName() {
		return paymentMethodName;
	}
	public void setPaymentMethodName(String paymentMethodName) {
		this.paymentMethodName = paymentMethodName;
	}
	public String getBillingCycle() {
		return billingCycle;
	}
	public void setBillingCycle(String billingCycle) {
		this.billingCycle = billingCycle;
	}
	public Date getNextDueDate() {
		return nextDueDate;
	}
	public void setNextDueDate(Date nextDueDate) {
		this.nextDueDate = nextDueDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public int getPromoId() {
		return promoId;
	}
	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}
	public String getOverideAutoSuspend() {
		return overideAutoSuspend;
	}
	public void setOverideAutoSuspend(String overideAutoSuspend) {
		this.overideAutoSuspend = overideAutoSuspend;
	}
	public Date getOverideSuspendUntil() {
		return overideSuspendUntil;
	}
	public void setOverideSuspendUntil(Date overideSuspendUntil) {
		this.overideSuspendUntil = overideSuspendUntil;
	}
	public String getNs1() {
		return ns1;
	}
	public void setNs1(String ns1) {
		this.ns1 = ns1;
	}
	public String getNs2() {
		return ns2;
	}
	public void setNs2(String ns2) {
		this.ns2 = ns2;
	}
	public String getAssignedIps() {
		return assignedIps;
	}
	public void setAssignedIps(String assignedIps) {
		this.assignedIps = assignedIps;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public int getDiskUsage() {
		return diskUsage;
	}
	public void setDiskUsage(int diskUsage) {
		this.diskUsage = diskUsage;
	}
	public int getDiskLimit() {
		return diskLimit;
	}
	public void setDiskLimit(int diskLimit) {
		this.diskLimit = diskLimit;
	}
	public int getBwUsage() {
		return bwUsage;
	}
	public void setBwUsage(int bwUsage) {
		this.bwUsage = bwUsage;
	}
	public int getBwLimit() {
		return bwLimit;
	}
	public void setBwLimit(int bwLimit) {
		this.bwLimit = bwLimit;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public List<CustomField> getCustomFields() {
		return customFields;
	}
	public void setCustomFields(List<CustomField> customFields) {
		this.customFields = customFields;
	}
	public List<ConfigOption> getConfigOptions() {
		return configOptions;
	}
	public void setConfigOptions(List<ConfigOption> configOptions) {
		this.configOptions = configOptions;
	}
    
	@Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", orderId=" + orderId +
                ", orderNumber='" + orderNumber + '\'' +
                ", pid=" + pid +
                ", regDate=" + regDate +
                ", name='" + name + '\'' +
                ", translatedName='" + translatedName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", translatedGroupName='" + translatedGroupName + '\'' +
                ", domain='" + domain + '\'' +
                ", dedicatedIp='" + dedicatedIp + '\'' +
                ", serverId=" + serverId +
                ", serverName='" + serverName + '\'' +
                ", serverIp='" + serverIp + '\'' +
                ", serverHostname='" + serverHostname + '\'' +
                ", suspensionReason='" + suspensionReason + '\'' +
                ", firstPaymentAmount=" + firstPaymentAmount +
                ", recurringAmount=" + recurringAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentMethodName='" + paymentMethodName + '\'' +
                ", billingCycle='" + billingCycle + '\'' +
                ", nextDueDate=" + nextDueDate +
                ", status='" + status + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", subscriptionId='" + subscriptionId + '\'' +
                ", promoId=" + promoId +
                ", overideAutoSuspend='" + overideAutoSuspend + '\'' +
                ", overideSuspendUntil=" + overideSuspendUntil +
                ", ns1='" + ns1 + '\'' +
                ", ns2='" + ns2 + '\'' +
                ", assignedIps='" + assignedIps + '\'' +
                ", notes='" + notes + '\'' +
                ", diskUsage=" + diskUsage +
                ", diskLimit=" + diskLimit +
                ", bwUsage=" + bwUsage +
                ", bwLimit=" + bwLimit +
                ", lastUpdate=" + lastUpdate +
                ", customFields=" + customFields +
                ", configOptions=" + configOptions +
                '}';
    }
    
}
