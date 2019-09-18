/**
 * 
 */
package org.apache.camel.hotwaxCommerce.dataObject;

public class PhoneNumber {
	 private String id;
	 private String externalId;
	 private String countryCode;
	 private String areaCode;
	 private String contactNumber;


	 // Getter Methods 

	 public String getId() {
	  return id;
	 }

	 public String getExternalId() {
	  return externalId;
	 }

	 public String getCountryCode() {
	  return countryCode;
	 }

	 public String getAreaCode() {
	  return areaCode;
	 }

	 public String getContactNumber() {
	  return contactNumber;
	 }

	 // Setter Methods 

	 public void setId(String id) {
	  this.id = id;
	 }

	 public void setExternalId(String externalId) {
	  this.externalId = externalId;
	 }

	 public void setCountryCode(String countryCode) {
	  this.countryCode = countryCode;
	 }

	 public void setAreaCode(String areaCode) {
	  this.areaCode = areaCode;
	 }

	 public void setContactNumber(String contactNumber) {
	  this.contactNumber = contactNumber;
	 }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PhoneNumber [id=" + id + ", externalId=" + externalId + ", countryCode=" + countryCode + ", areaCode="
				+ areaCode + ", contactNumber=" + contactNumber + "]";
	}
	 
	}
