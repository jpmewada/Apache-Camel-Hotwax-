/**
 * 
 */
package org.apache.camel.hotwaxCommerce.dataObject;

public class ItemAdjustments {
	 private String type;
	 private String taxAuthParty;
	 private String taxAuthGeoId;
	 private float amount;


	 // Getter Methods 

	 public String getType() {
	  return type;
	 }

	 public String getTaxAuthParty() {
	  return taxAuthParty;
	 }

	 public String getTaxAuthGeoId() {
	  return taxAuthGeoId;
	 }

	 public float getAmount() {
	  return amount;
	 }

	 // Setter Methods 

	 public void setType(String type) {
	  this.type = type;
	 }

	 public void setTaxAuthParty(String taxAuthParty) {
	  this.taxAuthParty = taxAuthParty;
	 }

	 public void setTaxAuthGeoId(String taxAuthGeoId) {
	  this.taxAuthGeoId = taxAuthGeoId;
	 }

	 public void setAmount(float amount) {
	  this.amount = amount;
	 }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemAdjustments [type=" + type + ", taxAuthParty=" + taxAuthParty + ", taxAuthGeoId=" + taxAuthGeoId
				+ ", amount=" + amount + "]";
	}
	 
}
