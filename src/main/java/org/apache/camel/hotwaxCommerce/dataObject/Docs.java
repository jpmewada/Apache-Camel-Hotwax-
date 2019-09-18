/**
 * 
 */
package org.apache.camel.hotwaxCommerce.dataObject;

import java.util.ArrayList;


public class Docs {
	private String id;
	private String externalId;
	private String type;
	private String invoiceDate;
	private String dueDate;
	private String paidDate;
	private String partyIdFrom;
	private String externalPartyIdFrom;
	private String partyIdTo;
	private String externalPartyIdTo;
	private String statusId;
	private String currencyCode;
	ArrayList < Items > items = new ArrayList < Items > ();
	ArrayList < InvoiceAdjustments > invoiceAdjustments = new ArrayList < InvoiceAdjustments > ();
	ShipFrom shipFrom;
	ShipTo shipTo;
	String gSTIN;
	BillTo billTo;


	// Getter Methods 

	public String getId() {
		return id;
	}

	public String getExternalId() {
		return externalId;
	}

	public String getType() {
		return type;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public String getPaidDate() {
		return paidDate;
	}

	public String getPartyIdFrom() {
		return partyIdFrom;
	}

	public String getExternalPartyIdFrom() {
		return externalPartyIdFrom;
	}

	public String getPartyIdTo() {
		return partyIdTo;
	}

	public String getExternalPartyIdTo() {
		return externalPartyIdTo;
	}

	public String getStatusId() {
		return statusId;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public ShipFrom getShipFrom() {
		return shipFrom;
	}

	public ShipTo getShipTo() {
		return shipTo;
	}

	public BillTo getBillTo() {
		return billTo;
	}

	// Setter Methods 

	public void setId(String id) {
		this.id = id;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}

	public void setPartyIdFrom(String partyIdFrom) {
		this.partyIdFrom = partyIdFrom;
	}

	public void setExternalPartyIdFrom(String externalPartyIdFrom) {
		this.externalPartyIdFrom = externalPartyIdFrom;
	}

	public void setPartyIdTo(String partyIdTo) {
		this.partyIdTo = partyIdTo;
	}

	public void setExternalPartyIdTo(String externalPartyIdTo) {
		this.externalPartyIdTo = externalPartyIdTo;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public void setShipFrom(ShipFrom shipFrom) {
		this.shipFrom = shipFrom;
	}

	public void setShipTo(ShipTo shipTo) {
		this.shipTo = shipTo;
	}

	public void setBillTo(BillTo billTo) {
		this.billTo = billTo;
	}

	/**
	 * @return the gSTIN
	 */
	public String getGSTIN() {
		return gSTIN;
	}

	/**
	 * @param gSTIN the gSTIN to set
	 */
	public void setGSTIN(String gSTIN) {
		this.gSTIN = gSTIN;
	}
	
	public ArrayList<Items> getItems() {
		return items;
	}

	public void setItems(ArrayList<Items> items) {
		this.items = items;
	}

	public ArrayList<InvoiceAdjustments> getInvoiceAdjustments() {
		return invoiceAdjustments;
	}

	public void setInvoiceAdjustments(ArrayList<InvoiceAdjustments> invoiceAdjustments) {
		this.invoiceAdjustments = invoiceAdjustments;
	}

	@Override
	public String toString() {
		return "Docs [id=" + id + ", externalId=" + externalId + ", type=" + type + ", invoiceDate=" + invoiceDate
				+ ", dueDate=" + dueDate + ", paidDate=" + paidDate + ", partyIdFrom=" + partyIdFrom
				+ ", externalPartyIdFrom=" + externalPartyIdFrom + ", partyIdTo=" + partyIdTo + ", externalPartyIdTo="
				+ externalPartyIdTo + ", statusId=" + statusId + ", currencyCode=" + currencyCode + ", items=" + items
				+ ", invoiceAdjustments=" + invoiceAdjustments + ", shipFrom=" + shipFrom + ", shipTo=" + shipTo
				+ ", gSTIN=" + gSTIN + ", billTo=" + billTo + "]";
	}

	

	
	
}

