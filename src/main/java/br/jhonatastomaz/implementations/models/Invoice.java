package br.jhonatastomaz.implementations.models;

import java.util.Date;

import br.jhonatastomaz.interfaces.IInvoice;
import br.jhonatastomaz.interfaces.details.IInvoiceDetails;


public class Invoice implements IInvoice{
    private int id;
    private int userId;
    private String invoiceNum;
    private Date date;
    private Date dueDate;
    private Date datePaid;
    private Date lastCaptureAttempt;
    private Date dateRefunded;
    private Date dateCancelled;
    private double subtotal;
    private double credit;
    private double tax;
    private double tax2;
    private double total;
    private double taxRate;
    private double taxRate2;
    private String status;
    private String paymentMethod;
    private String payMethodId;
    private String notes;
    private Date createdAt;
    private Date updatedAt;
    private String currencyCode;
    private String currencyPrefix;
    private String currencySuffix;
    private IInvoiceDetails invoiceDetails;
    
    public Invoice() {
    	
    }
  
    public int getId() {
        return id;
    }
  
    public void setId(int id) {
        this.id = id;
    }
  
    public int getUserId() {
        return userId;
    }
  
    public void setUserId(int user) {
        this.userId = user;
    }
  
    public String getInvoiceNum() {
        return invoiceNum;
    }
  
    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }
  
    public Date getDate() {
        return date;
    }
  
    public void setDate(Date date) {
        this.date = date;
    }
  
    public Date getDueDate() {
        return dueDate;
    }
  
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
  
    public Date getDatePaid() {
        return datePaid;
    }
  
    public void setDatePaid(Date datePaid) {
        this.datePaid = datePaid;
    }
  
    public Date getLastCaptureAttempt() {
        return lastCaptureAttempt;
    }
  
    public void setLastCaptureAttempt(Date lastCaptureAttempt) {
        this.lastCaptureAttempt = lastCaptureAttempt;
    }
  
    public Date getDateRefunded() {
        return dateRefunded;
    }
  
    public void setDateRefunded(Date dateRefunded) {
        this.dateRefunded = dateRefunded;
    }
  
    public Date getDateCancelled() {
        return dateCancelled;
    }
  
    public void setDateCancelled(Date dateCancelled) {
        this.dateCancelled = dateCancelled;
    }
  
    public double getSubtotal() {
        return subtotal;
    }
  
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
  
    public double getCredit() {
        return credit;
    }
  
    public void setCredit(double credit) {
        this.credit = credit;
    }
  
    public double getTax() {
        return tax;
    }
  
    public void setTax(double tax) {
        this.tax = tax;
    }
  
    public double getTax2() {
        return tax2;
    }
  
    public void setTax2(double tax2) {
        this.tax2 = tax2;
    }
  
    public double getTotal() {
        return total;
    }
  
    public void setTotal(double total) {
        this.total = total;
    }
  
    public double getTaxRate() {
        return taxRate;
    }
  
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
  
    public double getTaxRate2() {
        return taxRate2;
    }
  
    public void setTaxRate2(double taxRate2) {
        this.taxRate2 = taxRate2;
    }
  
    public String getStatus() {
        return status;
    }
  
    public void setStatus(String status) {
        this.status = status;
    }
  
    public String getPaymentMethod() {
        return paymentMethod;
    }
  
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
  
    public String getPayMethodId() {
        return payMethodId;
    }
  
    public void setPayMethodId(String payMethodId) {
        this.payMethodId = payMethodId;
    }
  
    public String getNotes() {
        return notes;
    }
  
    public void setNotes(String notes) {
        this.notes = notes;
    }
  
    public Date getCreatedAt() {
        return createdAt;
    }
  
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
  
    public Date getUpdatedAt() {
        return updatedAt;
    }
  
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
  
    public String getCurrencyCode() {
        return currencyCode;
    }
  
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
  
    public String getCurrencyPrefix() {
        return currencyPrefix;
    }
  
    public void setCurrencyPrefix(String currencyPrefix) {
        this.currencyPrefix = currencyPrefix;
    }
  
    public String getCurrencySuffix() {
        return currencySuffix;
    }
  
    public void setCurrencySuffix(String currencySuffix) {
        this.currencySuffix = currencySuffix;
    }

	public IInvoiceDetails getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(IInvoiceDetails invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}
   
}
