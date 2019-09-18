/**
 * 
 */
package org.apache.camel.hotwaxCommerce.dataObject;

public class PostalAddress {
	 private String id;
	 private String externalId;
	 private String toName;
	 private String address1;
	 private String address2;
	 private String city;
	 private String state;
	 private String postalCode;
	 private String country;


	 // Getter Methods 

	 public String getId() {
	  return id;
	 }

	 public String getExternalId() {
	  return externalId;
	 }

	 public String getToName() {
	  return toName;
	 }

	 public String getAddress1() {
	  return address1;
	 }

	 public String getAddress2() {
	  return address2;
	 }

	 public String getCity() {
	  return city;
	 }

	 public String getState() {
	  return state;
	 }

	 public String getPostalCode() {
	  return postalCode;
	 }

	 public String getCountry() {
	  return country;
	 }

	 // Setter Methods 

	 public void setId(String id) {
	  this.id = id;
	 }

	 public void setExternalId(String externalId) {
	  this.externalId = externalId;
	 }

	 public void setToName(String toName) {
	  this.toName = toName;
	 }

	 public void setAddress1(String address1) {
	  this.address1 = address1;
	 }

	 public void setAddress2(String address2) {
	  this.address2 = address2;
	 }

	 public void setCity(String city) {
	  this.city = city;
	 }

	 public void setState(String state) {
	  this.state = state;
	 }

	 public void setPostalCode(String postalCode) {
	  this.postalCode = postalCode;
	 }

	 public void setCountry(String country) {
	  this.country = country;
	 }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PostalAddress [id=" + id + ", externalId=" + externalId + ", toName=" + toName + ", address1="
				+ address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state + ", postalCode="
				+ postalCode + ", country=" + country + "]";
	}
	 
	 
	}
