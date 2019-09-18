/**
 * 
 */
package org.apache.camel.hotwaxCommerce.dataObject;

public class InvoiceAdjustments {
	
	private String type;
	private float amount;
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the amount
	 */
	public float getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InvoiceAdjustments [type=" + type + ", amount=" + amount + "]";
	}
	
}
