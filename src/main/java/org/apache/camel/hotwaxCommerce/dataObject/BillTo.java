/**
 * 
 */
package org.apache.camel.hotwaxCommerce.dataObject;


public class BillTo {
	
	PostalAddress postalAddress;
	PhoneNumber phoneNumber;
	Email email;


	// Getter Methods 

	public PostalAddress getPostalAddress() {
		return postalAddress;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public Email getEmail() {
		return email;
	}

	// Setter Methods 

	public void setPostalAddress(PostalAddress postalAddress) {
		this.postalAddress = postalAddress;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BillTo [postalAddress=" + postalAddress + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
	
}
