package org.apache.camel.avalara.dataObject;

import com.google.gson.annotations.SerializedName;

public class ShippingBill {
	
	@SerializedName("PortCode")
	private String portCode;
	
	@SerializedName("Value")
	private String value;


	// Getter Methods 

	public String getPortCode() {
		return portCode;
	}

	public String getValue() {
		return value;
	}

	// Setter Methods 

	public void setPortCode(String portCode) {
		this.portCode = portCode;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
