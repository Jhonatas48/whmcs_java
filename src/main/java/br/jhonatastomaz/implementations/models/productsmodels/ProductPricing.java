package br.jhonatastomaz.implementations.models.productsmodels;

public class ProductPricing {

	  private String prefix;
      private String suffix;
      private long msetupfee;
      private long qsetupfee;
      private long ssetupfee;
      private long asetupfee;
      private long bsetupfee;
      private long tsetupfee;
      private long monthly;
      private long quarterly;
      private long semiannually;
      private long annually;
      private long biennially;
      private long triennially;

      public String getPrefix() {
          return prefix;
      }

      public void setPrefix(String prefix) {
          this.prefix = prefix;
      }

      public String getSuffix() {
          return suffix;
      }

      public void setSuffix(String suffix) {
          this.suffix = suffix;
      }

      public long getMsetupfee() {
          return msetupfee;
      }

      public void setMsetupfee(long msetupfee) {
          this.msetupfee = msetupfee;
      }

      public long getQsetupfee() {
          return qsetupfee;
      }

      public void setQsetupfee(long qsetupfee) {
          this.qsetupfee = qsetupfee;
      }

      public long getSsetupfee() {
          return ssetupfee;
      }

      public void setSsetupfee(long ssetupfee) {
          this.ssetupfee = ssetupfee;
      }

      public long getAsetupfee() {
          return asetupfee;
      }

      public void setAsetupfee(long asetupfee) {
          this.asetupfee = asetupfee;
      }

      public long getBsetupfee() {
          return bsetupfee;
      }

      public void setBsetupfee(long bsetupfee) {
          this.bsetupfee = bsetupfee;
      }

      public long getTsetupfee() {
          return tsetupfee;
      }

      public void setTsetupfee(long tsetupfee) {
          this.tsetupfee = tsetupfee;
      }

      public long getMonthly() {
          return monthly;
      }

      public void setMonthly(long monthly) {
          this.monthly = monthly;
      }

      public long getQuarterly() {
          return quarterly;
      }

      public void setQuarterly(long quarterly) {
          this.quarterly = quarterly;
      }

      public long getSemiannually() {
          return semiannually;
      }

      public void setSemiannually(long semiannually) {
          this.semiannually = semiannually;
      }

      public long getAnnually() {
          return annually;
      }

      public void setAnnually(long annually) {
          this.annually = annually;
      }

      public long getBiennially() {
          return biennially;
      }

      public void setBiennially(long biennially) {
          this.biennially = biennially;
      }

      public long getTriennially() {
          return triennially;
      }

      public void setTriennially(long triennially) {
          this.triennially = triennially;
      }
}
