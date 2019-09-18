/**
 * 
 */
package org.apache.camel.avalara.txnapi.dataObject;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;


public class GstInList{
	List<GstIn> gstInList = new ArrayList<GstIn>();

	/**
	 * @return the gstInList
	 */
	public List<GstIn> getGstInList() {
		return gstInList;
	}

	/**
	 * @param gstInList the gstInList to set
	 */
	public void setGstInList(List<GstIn> gstInList) {
		this.gstInList = gstInList;
	}
	
	public String toJson() {
		Gson gson = new Gson();
		StringBuilder sb = new StringBuilder(gson.toJson(this));
		int i = sb.indexOf("{\"gstInList\":");
		if (i != -1) {
			sb.delete(i, i + "{\"gstInList\":".length());
		}
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}
}
