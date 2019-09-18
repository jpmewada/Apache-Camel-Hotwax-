package org.apache.camel.avalara.dataObject;

import com.google.gson.annotations.SerializedName;

public class Line {
	
	@SerializedName("HSNCode")
	private String hSNCode;
	
	@SerializedName("UnitQuantityCode")
	private String unitQuantityCode;
	
	@SerializedName("Number")
	private String number;
	
	@SerializedName("Description")
	private String description;
	
	@SerializedName("Quantity")
	private Double quantity;
	
	@SerializedName("TaxableAmount")
	private Double taxableAmount;
	
	@SerializedName("TaxAmount")
	private Double taxAmount;
	
	@SerializedName("TaxRate")
	private Double taxRate;
	
	@SerializedName("TDS")
	TDS tDS;
	
	@SerializedName("TCS")
	TCS tCS;
	
	@SerializedName("ITCSpecialHandling")
	private String iTCSpecialHandling;
	
	@SerializedName("IGST")
	private Double iGST;
	
	@SerializedName("IGSTRate")
	private Double iGSTRate;
	
	@SerializedName("CGST")
	private Double cGST;
	
	@SerializedName("CGSTRate")
	private Double cGSTRate;
	
	@SerializedName("SGST")
	private Double sGST;
	
	@SerializedName("SGSTRate")
	private Double sGSTRate;
	
	@SerializedName("CESS")
	private Double cESS;
	
	@SerializedName("CESSRate")
	private Double cESSRate;


	// Getter Methods 

	public String getHSNCode() {
		return hSNCode;
	}

	public String getUnitQuantityCode() {
		return unitQuantityCode;
	}

	public String getNumber() {
		return number;
	}

	public String getDescription() {
		return description;
	}

	public Double getQuantity() {
		return quantity;
	}

	public Double getTaxableAmount() {
		return taxableAmount;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public Double getTaxRate() {
		return taxRate;
	}

	public TDS getTDS() {
		return tDS;
	}

	public TCS getTCS() {
		return tCS;
	}

	public String getITCSpecialHandling() {
		return iTCSpecialHandling;
	}

	public Double getIGST() {
		return iGST;
	}

	public Double getIGSTRate() {
		return iGSTRate;
	}

	public Double getCGST() {
		return cGST;
	}

	public Double getCGSTRate() {
		return cGSTRate;
	}

	public Double getSGST() {
		return sGST;
	}

	public Double getSGSTRate() {
		return sGSTRate;
	}

	public Double getCESS() {
		return cESS;
	}

	public Double getCESSRate() {
		return cESSRate;
	}

	// Setter Methods 

	public void setHSNCode(String hSNCode) {
		this.hSNCode = hSNCode;
	}

	public void setUnitQuantityCode(String unitQuantityCode) {
		this.unitQuantityCode = unitQuantityCode;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public void setTaxableAmount(Double taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}

	public void setTDS(TDS tDS) {
		this.tDS = tDS;
	}

	public void setTCS(TCS tCS) {
		this.tCS = tCS;
	}

	public void setITCSpecialHandling(String iTCSpecialHandling) {
		this.iTCSpecialHandling = iTCSpecialHandling;
	}

	public void setIGST(Double iGST) {
		this.iGST = iGST;
	}

	public void setIGSTRate(Double iGSTRate) {
		this.iGSTRate = iGSTRate;
	}

	public void setCGST(Double cGST) {
		this.cGST = cGST;
	}

	public void setCGSTRate(Double cGSTRate) {
		this.cGSTRate = cGSTRate;
	}

	public void setSGST(Double sGST) {
		this.sGST = sGST;
	}

	public void setSGSTRate(Double sGSTRate) {
		this.sGSTRate = sGSTRate;
	}

	public void setCESS(Double cESS) {
		this.cESS = cESS;
	}

	public void setCESSRate(Double cESSRate) {
		this.cESSRate = cESSRate;
	}
}
