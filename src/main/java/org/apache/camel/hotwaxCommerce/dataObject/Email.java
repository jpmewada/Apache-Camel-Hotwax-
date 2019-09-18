/**
 * 
 */
package org.apache.camel.hotwaxCommerce.dataObject;


public class Email {
	 private String id;
	 private String externalId;
	 private String email;


	 // Getter Methods 

	 public String getId() {
	  return id;
	 }

	 public String getExternalId() {
	  return externalId;
	 }

	 public String getEmail() {
	  return email;
	 }

	 // Setter Methods 

	 public void setId(String id) {
	  this.id = id;
	 }

	 public void setExternalId(String externalId) {
	  this.externalId = externalId;
	 }

	 public void setEmail(String email) {
	  this.email = email;
	 }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Email [id=" + id + ", externalId=" + externalId + ", email=" + email + "]";
	}
	 
	}
