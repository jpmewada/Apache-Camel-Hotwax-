package org.apache.camel.avalara.dataObject;

import com.google.gson.annotations.SerializedName;

public class ShipTo {
	
	@SerializedName("City")
	private String city;
	
	@SerializedName("State")
	private String state;
	
	@SerializedName("Line1")
	private String line1;
	
	@SerializedName("Country")
	private String country;
	
	@SerializedName("PostalCode")
	private String postalCode;


	// Getter Methods 

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getLine1() {
		return line1;
	}

	public String getCountry() {
		return country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	// Setter Methods 

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
