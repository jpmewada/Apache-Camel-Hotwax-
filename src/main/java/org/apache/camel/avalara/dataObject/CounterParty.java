package org.apache.camel.avalara.dataObject;

import com.google.gson.annotations.SerializedName;

public class CounterParty {
	
	@SerializedName("GSTIN")
	private String gSTIN;
	
	@SerializedName("Name")
	private String name;
	
	@SerializedName("UIN")
	private String uIN;


	// Getter Methods 

	public String getGSTIN() {
		return gSTIN;
	}

	public String getName() {
		return name;
	}

	public String getUIN() {
		return uIN;
	}

	// Setter Methods 

	public void setGSTIN(String gSTIN) {
		this.gSTIN = gSTIN;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUIN(String uIN) {
		this.uIN = uIN;
	}
}
