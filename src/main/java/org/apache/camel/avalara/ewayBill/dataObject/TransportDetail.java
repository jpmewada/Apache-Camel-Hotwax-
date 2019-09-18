/**
 * 
 */
package org.apache.camel.avalara.ewayBill.dataObject;


public class TransportDetail {
	private String name;
	private String transporterId;
	private String modeOfTransport;
	private String documentNumber;
	private String documentDate;
	private int distance;
	private String vehicleNo;
	private String vehicleType;


	// Getter Methods 

	public String getName() {
		return name;
	}

	public String getTransporterId() {
		return transporterId;
	}

	public String getModeOfTransport() {
		return modeOfTransport;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public String getDocumentDate() {
		return documentDate;
	}

	public int getDistance() {
		return distance;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	// Setter Methods 

	public void setName(String name) {
		this.name = name;
	}

	public void setTransporterId(String transporterId) {
		this.transporterId = transporterId;
	}

	public void setModeOfTransport(String modeOfTransport) {
		this.modeOfTransport = modeOfTransport;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public void setDocumentDate(String documentDate) {
		this.documentDate = documentDate;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
}
