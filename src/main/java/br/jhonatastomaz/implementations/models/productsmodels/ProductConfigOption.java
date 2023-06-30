package br.jhonatastomaz.implementations.models.productsmodels;

import java.util.Map;

public class ProductConfigOption {

	 private int id;
     private String name;
     private String type;
     private Map<Integer, ProductCurrency> options;

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getType() {
         return type;
     }

     public void setType(String type) {
         this.type = type;
     }

     public Map<Integer, ProductCurrency> getOptions() {
         return options;
     }

     public void setOptions(Map<Integer, ProductCurrency> options) {
         this.options = options;
     }
}
