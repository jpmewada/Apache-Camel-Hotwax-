package org.apache.camel.avalara.dataObject;

import com.google.gson.annotations.SerializedName;

public class OriginalDocument {
	
	@SerializedName("Number")
	private String number;


	// Getter Methods 

	public String getNumber() {
		return number;
	}

	// Setter Methods 

	public void setNumber(String number) {
		this.number = number;
	}
}
