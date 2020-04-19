package com.revature.model;

public class Imbursements {

    private int imbId;
    private double imbAmount;
    private String imbSubmitted;
    private String imbResolved;
    private String imbDescription;
    private String imbReceipt;
    private int imbAuthor;
    private int imbResolver;
    private int imbStatus;
    private int imbType;
    
    public int getImbId() {
      return imbId;
    }
    public void setImbId(int imbId) {
      this.imbId = imbId;
    }
    public double getImbAmount() {
      return imbAmount;
    }
    public void setImbAmount(double imbAmount) {
      this.imbAmount = imbAmount;
    }
    public String getImbSubmitted() {
      return imbSubmitted;
    }
    public void setImbSubmitted(String imbSubmitted) {
      this.imbSubmitted = imbSubmitted;
    }
    public String getImbResolved() {
      return imbResolved;
    }
    public void setImbResolved(String imbResolved) {
      this.imbResolved = imbResolved;
    }
    public String getImbDescription() {
      return imbDescription;
    }
    public void setImbDescription(String imbDescription) {
      this.imbDescription = imbDescription;
    }
    public String getImbReceipt() {
      return imbReceipt;
    }
    public void setImbReceipt(String imbReceipt) {
      this.imbReceipt = imbReceipt;
    }
    public int getImbAuthor() {
      return imbAuthor;
    }
    public void setImbAuthor(int imbAuthor) {
      this.imbAuthor = imbAuthor;
    }
    public int getImbResolver() {
      return imbResolver;
    }
    public void setImbResolver(int imbResolver) {
      this.imbResolver = imbResolver;
    }
    public int getImbStatus() {
      return imbStatus;
    }
    public void setImbStatus(int imbStatus) {
      this.imbStatus = imbStatus;
    }
    public int getImbType() {
      return imbType;
    }
    public void setImbType(int imbType) {
      this.imbType = imbType;
    }
    @Override
    public String toString() {
      return "Imbursements [imbId=" + imbId + ", imbAmount=" + imbAmount + ", imbSubmitted="
          + imbSubmitted + ", imbResolved=" + imbResolved + ", imbDescription=" + imbDescription
          + ", imbReceipt=" + imbReceipt + ", imbAuthor=" + imbAuthor + ", imbResolver="
          + imbResolver + ", imbStatus=" + imbStatus + ", imbType=" + imbType + "]";
    }
    public Imbursements() {
      super();
      // TODO Auto-generated constructor stub
    }
    
    public Imbursements(double imbAmount,String imbDescription, int imbAuthor, int imbType) {
      super();
      this.imbAmount = imbAmount;
      this.imbDescription = imbDescription;
      this.imbAuthor = imbAuthor;
      this.imbType = imbType;
    }
    
    public Imbursements(int imbId, double imbAmount, String imbSubmitted, String imbResolved,
        String imbDescription, String imbReceipt, int imbAuthor, int imbResolver,
        int imbStatus, int imbType) {
      super();
      this.imbId = imbId;
      this.imbAmount = imbAmount;
      this.imbSubmitted = imbSubmitted;
      this.imbResolved = imbResolved;
      this.imbDescription = imbDescription;
      this.imbReceipt = imbReceipt;
      this.imbAuthor = imbAuthor;
      this.imbResolver = imbResolver;
      this.imbStatus = imbStatus;
      this.imbType = imbType;
    }
    
}
