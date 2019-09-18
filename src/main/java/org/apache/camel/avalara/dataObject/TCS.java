package org.apache.camel.avalara.dataObject;

import com.google.gson.annotations.SerializedName;

public class TCS {
	
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
