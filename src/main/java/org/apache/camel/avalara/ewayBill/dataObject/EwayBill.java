/**
 * 
 */
package org.apache.camel.avalara.ewayBill.dataObject;


public class EwayBill {
	 private String subType;
	 private String documentType;
	 private String subTypeDesc;
	 TransportDetail transportDetail;
	 private boolean generate;


	 // Getter Methods 

	 public String getSubType() {
	  return subType;
	 }

	 public String getDocumentType() {
	  return documentType;
	 }

	 public String getSubTypeDesc() {
	  return subTypeDesc;
	 }

	 public TransportDetail getTransportDetail() {
	  return transportDetail;
	 }

	 public boolean getGenerate() {
	  return generate;
	 }

	 // Setter Methods 

	 public void setSubType(String subType) {
	  this.subType = subType;
	 }

	 public void setDocumentType(String documentType) {
	  this.documentType = documentType;
	 }

	 public void setSubTypeDesc(String subTypeDesc) {
	  this.subTypeDesc = subTypeDesc;
	 }

	 public void setTransportDetail(TransportDetail transportDetail) {
	  this.transportDetail = transportDetail;
	 }

	 public void setGenerate(boolean generate) {
	  this.generate = generate;
	 }
	}
