/**
 * 
 */
package org.apache.camel.avalara.ewayBill.dataObject;

import java.util.ArrayList;

import org.apache.camel.avalara.dataObject.CounterParty;
import org.apache.camel.avalara.dataObject.ECommOprMerchant;
import org.apache.camel.avalara.dataObject.Line;
import org.apache.camel.avalara.dataObject.OriginalDocument;
import org.apache.camel.avalara.dataObject.ShipFrom;
import org.apache.camel.avalara.dataObject.ShipTo;
import org.apache.camel.avalara.dataObject.ShippingBill;

import com.google.gson.annotations.SerializedName;


public class Invoice {
	 EwayBill ewayBill;
	 
	 @SerializedName("GSTIN")
	 private String gSTIN;
	 
	 CounterParty counterParty;
	 
	 @SerializedName("Number")
	 private String number;
	 
	 @SerializedName("Type")
	 private String type;
	 
	 @SerializedName("Date")
	 private String date;
	 
	 @SerializedName("POS")
	 private String pOS;
	 
	 ShippingBill shippingBill;
	 
	 @SerializedName("ExportType")
	 private String exportType;
	 
	 OriginalDocument originalDocument;
	 
	 @SerializedName("CDNReason")
	 private String cDNReason;
	 
	 ECommOprMerchant eCommOprMerchant;
	 
	 @SerializedName("PGST")
	 private boolean pGST;
	 
	 ShipFrom shipFrom;
	 ShipTo shipTo;
	 
	 @SerializedName("Lines")
	 ArrayList < Line > lines = new ArrayList < Line > ();


	 // Getter Methods 

	 public EwayBill getEwayBill() {
	  return ewayBill;
	 }

	 public String getGSTIN() {
	  return gSTIN;
	 }

	 public CounterParty getCounterParty() {
	  return counterParty;
	 }

	 public String getNumber() {
	  return number;
	 }

	 public String getType() {
	  return type;
	 }

	 public String getDate() {
	  return date;
	 }

	 public String getPOS() {
	  return pOS;
	 }

	 public ShippingBill getShippingBill() {
	  return shippingBill;
	 }

	 public String getExportType() {
	  return exportType;
	 }

	 public OriginalDocument getOriginalDocument() {
	  return originalDocument;
	 }

	 public String getCDNReason() {
	  return cDNReason;
	 }

	 public ECommOprMerchant getECommOprMerchant() {
	  return eCommOprMerchant;
	 }

	 public boolean getPGST() {
	  return pGST;
	 }

	 public ShipFrom getShipFrom() {
	  return shipFrom;
	 }

	 public ShipTo getShipTo() {
	  return shipTo;
	 }

	 // Setter Methods 

	 public void setEwayBill(EwayBill ewayBill) {
	  this.ewayBill = ewayBill;
	 }

	 public void setGSTIN(String gSTIN) {
	  this.gSTIN = gSTIN;
	 }

	 public void setCounterParty(CounterParty counterParty) {
	  this.counterParty = counterParty;
	 }

	 public void setNumber(String number) {
	  this.number = number;
	 }

	 public void setType(String type) {
	  this.type = type;
	 }

	 public void setDate(String date) {
	  this.date = date;
	 }

	 public void setPOS(String pOS) {
	  this.pOS = pOS;
	 }

	 public void setShippingBill(ShippingBill shippingBill) {
	  this.shippingBill = shippingBill;
	 }

	 public void setExportType(String exportType) {
	  this.exportType = exportType;
	 }

	 public void setOriginalDocument(OriginalDocument originalDocument) {
	  this.originalDocument = originalDocument;
	 }

	 public void setCDNReason(String cDNReason) {
	  this.cDNReason = cDNReason;
	 }

	 public void setECommOprMerchant(ECommOprMerchant eCommOprMerchant) {
	  this.eCommOprMerchant = eCommOprMerchant;
	 }

	 public void setPGST(boolean pGST) {
	  this.pGST = pGST;
	 }

	 public void setShipFrom(ShipFrom shipFrom) {
	  this.shipFrom = shipFrom;
	 }

	 public void setShipTo(ShipTo shipTo) {
	  this.shipTo = shipTo;
	 }

	public ECommOprMerchant geteCommOprMerchant() {
		return eCommOprMerchant;
	}

	public void seteCommOprMerchant(ECommOprMerchant eCommOprMerchant) {
		this.eCommOprMerchant = eCommOprMerchant;
	}

	public ArrayList<Line> getLines() {
		return lines;
	}

	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}
	 
	 
}
	
