package org.apache.camel.avalara.dataObject;

import com.google.gson.annotations.SerializedName;

public class ECommOprMerchant {
	
	@SerializedName("Id")
	private String id;
	
	@SerializedName("GSTIN")
	private String gSTIN;


	// Getter Methods 

	public String getId() {
		return id;
	}

	public String getgSTIN() {
		return gSTIN;
	}

	// Setter Methods 

	public void setId(String id) {
		this.id = id;
	}

	public void setGSTIN(String gSTIN) {
		this.gSTIN = gSTIN;
	}
}
