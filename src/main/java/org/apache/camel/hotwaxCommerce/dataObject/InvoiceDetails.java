/**
 * 
 */
package org.apache.camel.hotwaxCommerce.dataObject;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class InvoiceDetails {
	 private String count;
	 List <Docs> docs = new ArrayList <Docs> ();
	 private String _error_message_;
	 private String webSiteId;

	 // Getter Methods 

	 

	public String getCount() {
	  return count;
	 }

	 // Setter Methods 

	 /**
	 * @return the _error_message_
	 */
	public String get_error_message_() {
		return _error_message_;
	}

	/**
	 * @return the webSiteId
	 */
	public String getWebSiteId() {
		return webSiteId;
	}

	/**
	 * @param webSiteId the webSiteId to set
	 */
	public void setWebSiteId(String webSiteId) {
		this.webSiteId = webSiteId;
	}

	/**
	 * @param _error_message_ the _error_message_ to set
	 */
	public void set_error_message_(String _error_message_) {
		this._error_message_ = _error_message_;
	}

	public void setCount(String count) {
	  this.count = count;
	 }
	 
	 public static InvoiceDetails toInvoiceDetails(String json) {
		 Gson gson = new Gson();
		 return gson.fromJson(json, InvoiceDetails.class);
	 }
	 
	public List<Docs> getDocs() {
		return docs;
	}

	public void setDocs(List<Docs> docs) {
		this.docs = docs;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InvoiceDetails [docs=" + docs + "]";
	}
	 
	 
}
