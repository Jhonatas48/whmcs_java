package br.jhonatastomaz.implementations.models;

import br.jhonatastomaz.interfaces.IItemInvoice;

public class ItemInvoice implements IItemInvoice{
	private int id;
    private String type;
    private int relid;
    private String description;
    private double amount;
    private int taxed;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRelid() {
        return relid;
    }

    public void setRelid(int relid) {
        this.relid = relid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getTaxed() {
        return taxed;
    }

    public void setTaxed(int taxed) {
        this.taxed = taxed;
    }
}
