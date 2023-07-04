package br.jhonatastomaz.implementations.models;

import java.util.Date;

import br.jhonatastomaz.interfaces.ITransaction;

public class Transaction implements ITransaction{
	    private int id;
	    private int userid;
	    private int currency;
	    private String gateway;
	    private Date date;
	    private String description;
	    private double amountin;
	    private double fees;
	    private double amountout;
	    private String rate;
	    private String transid;
	    private int invoiceid;
	    private int refundid;

	    @Override
	    public int getId() {
	        return id;
	    }

	    @Override
	    public void setId(int id) {
	        this.id = id;
	    }

	    @Override
	    public int getUserid() {
	        return userid;
	    }

	    @Override
	    public void setUserid(int userid) {
	        this.userid = userid;
	    }

	    @Override
	    public int getCurrency() {
	        return currency;
	    }

	    @Override
	    public void setCurrency(int currency) {
	        this.currency = currency;
	    }

	    @Override
	    public String getGateway() {
	        return gateway;
	    }

	    @Override
	    public void setGateway(String gateway) {
	        this.gateway = gateway;
	    }

	    @Override
	    public Date getDate() {
	        return date;
	    }

	    @Override
	    public void setDate(Date date) {
	        this.date = date;
	    }

	    @Override
	    public String getDescription() {
	        return description;
	    }

	    @Override
	    public void setDescription(String description) {
	        this.description = description;
	    }

	    @Override
	    public double getAmountIn() {
	        return amountin;
	    }

	    @Override
	    public void setAmountIn(double amountin) {
	        this.amountin = amountin;
	    }

	    @Override
	    public double getFees() {
	        return fees;
	    }

	    @Override
	    public void setFees(double fees) {
	        this.fees = fees;
	    }

	    @Override
	    public double getAmountOut() {
	        return amountout;
	    }

	    @Override
	    public void setAmountOut(double amountout) {
	        this.amountout = amountout;
	    }

	    @Override
	    public String getRate() {
	        return rate;
	    }

	    @Override
	    public void setRate(String rate) {
	        this.rate = rate;
	    }

	    @Override
	    public String getTransid() {
	        return transid;
	    }

	    @Override
	    public void setTransid(String transid) {
	        this.transid = transid;
	    }

	    @Override
	    public int getInvoiceid() {
	        return invoiceid;
	    }

	    @Override
	    public void setInvoiceid(int invoiceid) {
	        this.invoiceid = invoiceid;
	    }

	    @Override
	    public int getRefundid() {
	        return refundid;
	    }

	    @Override
	    public void setRefundid(int refundid) {
	        this.refundid = refundid;
	    }
}
