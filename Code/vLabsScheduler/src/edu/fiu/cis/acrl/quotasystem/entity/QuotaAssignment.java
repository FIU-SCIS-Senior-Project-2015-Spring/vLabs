package edu.fiu.cis.acrl.quotasystem.entity;


public class QuotaAssignment {
	
	String purchaseId;
	CreditType creditType;
	float quantity;
	float percentageReturned;
	boolean active;
	
	
	public String getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}
	public CreditType getCreditType() {
		return creditType;
	}
	public void setCreditType(CreditType creditType) {
		this.creditType = creditType;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public float getPercentageReturned() {
		return percentageReturned;
	}
	public void setPercentageReturned(float percentageReturned) {
		this.percentageReturned = percentageReturned;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "QuotaAssignment [purchaseId=" + purchaseId + ", creditType="
				+ creditType + ", quantity=" + quantity
				+ ", percentageReturned=" + percentageReturned + ", active="
				+ active + "]";
	}
	

	
	

}
