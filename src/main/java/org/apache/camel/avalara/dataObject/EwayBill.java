package org.apache.camel.avalara.dataObject;

import com.google.gson.annotations.SerializedName;

public class EwayBill {
	
	@SerializedName("Id")
	private String id;


	// Getter Methods 

	public String getId() {
		return id;
	}

	// Setter Methods 

	public void setId(String id) {
		this.id = id;
	}
}
