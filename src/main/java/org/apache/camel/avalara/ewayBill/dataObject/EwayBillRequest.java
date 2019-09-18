/**
 * 
 */
package org.apache.camel.avalara.ewayBill.dataObject;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;


public class EwayBillRequest {
	List<Invoice> invoiceList = new ArrayList<Invoice>();
	
	public List<Invoice> getInvoiceList() {
		return invoiceList;
	}



	public void setInvoiceList(List<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}

	public String toJson() {
		Gson gson = new Gson();
		StringBuilder sb = new StringBuilder(gson.toJson(this));
		int i = sb.indexOf("{\"invoiceList\":");
		if (i != -1) {
			sb.delete(i, i + "{\"invoiceList\":".length());
		}
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}
}
