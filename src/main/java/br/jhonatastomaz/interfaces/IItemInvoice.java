package br.jhonatastomaz.interfaces;

public interface IItemInvoice {

	int getId();
    void setId(int id);
    String getType();
    void setType(String type);
    int getRelid();
    void setRelid(int relid);
    String getDescription();
    void setDescription(String description);
    double getAmount();
    void setAmount(double amount);
    int getTaxed();
    void setTaxed(int taxed);
}
