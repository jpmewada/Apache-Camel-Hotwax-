package org.apache.camel.avalara.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.avalara.dataObject.Line;
import org.apache.camel.avalara.dataObject.ShipFrom;
import org.apache.camel.avalara.dataObject.ShipTo;
import org.apache.camel.avalara.ewayBill.dataObject.EwayBillRequest;
import org.apache.camel.avalara.ewayBill.dataObject.Invoice;
import org.apache.camel.avalara.ewayBill.dataObject.TransportDetail;
import org.apache.camel.avalara.txnapi.dataObject.GstIn;
import org.apache.camel.avalara.txnapi.dataObject.GstInList;
import org.apache.camel.hotwaxCommerce.dataObject.Docs;
import org.apache.camel.hotwaxCommerce.dataObject.InvoiceDetails;
import org.apache.camel.hotwaxCommerce.dataObject.Items;

public class AvalaraUtils {
	
	/**
	**This map can be used to convert HC type to Avalara supported type
	**/
	static Map<String,String> typeMap = new HashMap<String,String>(){
		private static final long serialVersionUID = 1L;
		{
	      	put("SALES_INVOICE", "AR-IN");
	        put("SALES_INVOICE, REVERSE_CHARGED", "AR-IN-RC");
	        put("SALES_INVOICE, EXPORT", "AR-IN-EX");
	        put("AR_CREDIT_MEMO_OR_NOTE/SALES_RETURN_INVOICE", "AR-CR");
	        put("SALES_INVOICE, AGAINST ADVANCE", "AR-IN-PY");
	        put("AR_DEBIT_NOTE", "AR-DB");
		}
	};
	/**
	**This map can be used to convert states to their codes
	**/
	static Map<String, String> stateMap = new HashMap<String, String>(){
	    private static final long serialVersionUID = 1L;
	    {
	        put("IN-JK", "01");
	        put("IN-HP", "02");
	        put("IN-PB", "03");
	        put("IN-CH", "04");
	        put("IN-UT", "05");
	        put("IN-HR", "06");
	        put("IN-DL", "07");
	        put("IN-RJ", "08");
	        put("IN-UP", "09");
	        put("IN-BR", "10");
	        put("IN-SK", "11");
	        put("IN-AR", "12");
	        put("IN-NL", "13");
	        put("IN-MN", "14");
	        put("IN-MZ", "15");
	        put("IN-TR", "16");
	        put("IN-MZ", "17");
	        put("IN-AS", "18");
	        put("IN-WB", "19");
	        put("IN-JH", "20");
	        put("IN-OR", "21");
	        put("IN-CT", "22");
	        put("IN-MP", "23");
	        put("IN-GJ", "24");
	        put("IN-DD", "25");
	        put("IN-DN", "26");
	        put("IN-MH", "27");
	        put("IN-AP", "28");
	        put("IN-KA", "29");
	        put("IN-GA", "30");
	        put("IN-LD", "31");
	        put("IN-KL", "32");
	        put("IN-TN", "33");
	        put("IN-PY", "34");
	        put("IN-AN", "35");
	        put("IN-TG", "36");
	        put("IN-AP", "37");
	    }
	};
	
	/**
	**This method is responsible to populate the GstInList java object, 
	**further this java object can be converted to json and send to Avalara
	**/
	public static void populateTxnRequest(GstInList gstInListObject, InvoiceDetails invoiceDetails) {
		Docs docs;
		GstIn gstIn;
		StringBuilder stringBuilder  = new StringBuilder();
		List<Docs> docsList = invoiceDetails.getDocs();
		for(int i=0; i< docsList.size(); i++) {
			docs = (Docs)docsList.get(i);
			gstIn = new GstIn();
			
			docs.setGSTIN("23AAUCS3592A1Z9");
			
			if(docs.getGSTIN() != null) {
				gstIn.setGSTIN(docs.getGSTIN());
			}else {
				stringBuilder.append("\"GSTIN\" ");
			}

			if(docs.getId() != null) {
				gstIn.setNumber(docs.getId());
			}else {
				stringBuilder.append("\"Number\" ");
			}

			if(docs.getType() != null) {
				gstIn.setType(typeMap.get(docs.getType()));
			}else {
				stringBuilder.append("\"Type\" ");
			}

			if(docs.getInvoiceDate() != null) {
				Date date;
				try {
					date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(docs.getInvoiceDate());
					gstIn.setDate(new SimpleDateFormat("yyyy-MM-dd").format(date));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				stringBuilder.append("\"Date\" ");
			}

			ShipFrom shipFrom = new ShipFrom();
			if(docs.getShipFrom().getPostalAddress().getCity() != null) {
				shipFrom.setCity(docs.getShipFrom().getPostalAddress().getCity());
			}

			if(docs.getShipFrom().getPostalAddress().getState() != null) {
				shipFrom.setState(stateMap.get(docs.getShipTo().getPostalAddress().getState()));
			}else {
				stringBuilder.append("\"ShipFrom State\" ");
			}

			shipFrom.setCountry("IN");

			if(docs.getShipFrom().getPostalAddress().getPostalCode() != null) {
				shipFrom.setPostalCode(docs.getShipFrom().getPostalAddress().getPostalCode());
			}
			gstIn.setShipFrom(shipFrom);

			ShipTo shipTo = new ShipTo();
			if(docs.getShipTo().getPostalAddress().getCity() != null) {
				shipTo.setCity(docs.getShipTo().getPostalAddress().getCity());
			}

			if(docs.getShipTo().getPostalAddress().getState() != null) {
				shipTo.setState(stateMap.get(docs.getShipTo().getPostalAddress().getState()));
			}else {
				stringBuilder.append("\"ShipFrom State\" ");
			}

			shipTo.setCountry("IN");

			if(docs.getShipTo().getPostalAddress().getPostalCode() != null) {
				shipTo.setPostalCode(docs.getShipTo().getPostalAddress().getPostalCode());
			}
			gstIn.setShipTo(shipTo);
			List<Items> itemsList = docs.getItems();
			
			for(int j=0; j<itemsList.size(); j++) {
				Items item = (Items) itemsList.get(j);

				Line line = new Line();
				line.setHSNCode(item.getHsnCode());

				line.setQuantity(new Double(item.getQuantity()));

				gstIn.getLines().add(line);
			}
			gstInListObject.getGstInList().add(gstIn);
		}
	}
	
	/**
	**This method is responsible to populate the EwayBillRequest java object, 
	**further this java object can be converted to json and send to Avalara
	**/
	public static void populateEwayBillRequest(EwayBillRequest ewayBillRequest, InvoiceDetails invoiceDetails) {
		Docs docs;
		Invoice invoice;
		StringBuilder stringBuilder  = new StringBuilder();
		List< Docs > docsList = invoiceDetails.getDocs();
		for(int i=0; i< docsList.size(); i++) {
			docs = (Docs)docsList.get(i);
			invoice = new Invoice();
			
			org.apache.camel.avalara.ewayBill.dataObject.EwayBill ewayBill = new org.apache.camel.avalara.ewayBill.dataObject.EwayBill();
			ewayBill.setSubType("Others");
			ewayBill.setDocumentType("Others");
			ewayBill.setSubTypeDesc("Other Specify filed.");
			TransportDetail transportDetail = new TransportDetail();
			transportDetail.setModeOfTransport("Road");
			transportDetail.setDocumentNumber("Intra-doc1");
			transportDetail.setDocumentDate("2019-01-21");
			transportDetail.setDistance(780);
			transportDetail.setVehicleNo("PB03YS1234");
			transportDetail.setVehicleType("Regular");
			ewayBill.setTransportDetail(transportDetail);
			ewayBill.setGenerate(true);
			invoice.setEwayBill(ewayBill);
			
			docs.setGSTIN("03EHFPS5910D3A1");
			
			if(docs.getGSTIN() != null) {
				invoice.setGSTIN(docs.getGSTIN());
			}else {
				stringBuilder.append("\"GSTIN\" ");
			}

			if(docs.getId() != null) {
				invoice.setNumber("5"+docs.getId());
			}else {
				stringBuilder.append("\"Number\" ");
			}

			if(docs.getType() != null) {
				invoice.setType(typeMap.get(docs.getType()));
			}else {
				stringBuilder.append("\"Type\" ");
			}

			if(docs.getInvoiceDate() != null) {
				Date date;
				try {
					date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(docs.getInvoiceDate());
					invoice.setDate(new SimpleDateFormat("yyyy-MM-dd").format(date));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				stringBuilder.append("\"Date\" ");
			}

			ShipFrom shipFrom = new ShipFrom();
			if(docs.getShipFrom().getPostalAddress().getCity() != null) {
				shipFrom.setCity(docs.getShipFrom().getPostalAddress().getCity());
			}

			if(docs.getShipFrom().getPostalAddress().getState() != null) {
				shipFrom.setState(stateMap.get(docs.getShipFrom().getPostalAddress().getState()));
			}else {
				stringBuilder.append("\"ShipFrom State\" ");
			}

			if(docs.getShipFrom().getPostalAddress().getAddress1() != null) {
						shipFrom.setLine1(docs.getShipFrom().getPostalAddress().getAddress1());
			}

			shipFrom.setCountry("IN");

			if(docs.getShipFrom().getPostalAddress().getPostalCode() != null) {
				shipFrom.setPostalCode(docs.getShipFrom().getPostalAddress().getPostalCode());
			}
			invoice.setShipFrom(shipFrom);

			ShipTo shipTo = new ShipTo();
			if(docs.getShipTo().getPostalAddress().getCity() != null) {
				shipTo.setCity(docs.getShipTo().getPostalAddress().getCity());
			}

			if(docs.getShipTo().getPostalAddress().getState() != null) {
				shipTo.setState(stateMap.get(docs.getShipTo().getPostalAddress().getState()));
			}else {
				stringBuilder.append("\"ShipFrom State\" ");
			}

			shipTo.setCountry("IN");

			if(docs.getShipTo().getPostalAddress().getPostalCode() != null) {
				shipTo.setPostalCode(docs.getShipTo().getPostalAddress().getPostalCode());
			}
			invoice.setShipTo(shipTo);
			
			List<Items> itemsList = docs.getItems();
			
			for(int j=0; j<itemsList.size(); j++) {
				Items item = (Items) itemsList.get(j);

				Line line = new Line();
				line.setHSNCode(item.getHsnCode());
				line.setUnitQuantityCode("NOS");
				line.setQuantity(new Double(item.getQuantity()));
				line.setTaxableAmount(0.0);
				line.setIGSTRate(0.0);
				line.setCGSTRate(0.0);
				line.setSGSTRate(0.0);
				line.setCESSRate(0.0);

				invoice.getLines().add(line);
			}
			ewayBillRequest.getInvoiceList().add(invoice);
		}
	}
	
	/**
	**This method is responsible to calculate the CGST rate by using CGST amount
	**/
	/*static Double getCGSTRate(Items item) {
		double rate = 0.0;
		List itemAdjustList = item.getItemAdjustments();
		ItemAdjustments itemAdjustment;
		for(int i=0; i<itemAdjustList.size(); i++) {
			itemAdjustment = (ItemAdjustments) itemAdjustList.get(i);
			if(itemAdjustment.getTaxAuthParty() != null && itemAdjustment.getTaxAuthParty().contains("CGST")) {
				rate = (itemAdjustment.getAmount()/item.getAmount()) * 100;
			}
		}
		return rate;
	}
	
	*//**
	**This method is responsible to calculate the IGST rate by using IGST amount
	**//*
	static Double getIGSTRate(Items item) {
		double rate = 0.0;
		List itemAdjustList = item.getItemAdjustments();
		ItemAdjustments itemAdjustment;
		for(int i=0; i<itemAdjustList.size(); i++) {
			itemAdjustment = (ItemAdjustments) itemAdjustList.get(i);
			if(itemAdjustment.getTaxAuthParty() != null && itemAdjustment.getTaxAuthParty().contains("IGST")) {
				rate = (itemAdjustment.getAmount()/item.getAmount()) * 100;
			}
		}
		return rate;
	}
	
	*//**
	**This method is responsible to calculate the SGST rate by using SGST amount
	**//*
	static Double getSGSTRate(Items item) {
		double rate = 0.0;
		List itemAdjustList = item.getItemAdjustments();
		ItemAdjustments itemAdjustment;
		for(int i=0; i<itemAdjustList.size(); i++) {
			itemAdjustment = (ItemAdjustments) itemAdjustList.get(i);
			if(itemAdjustment.getTaxAuthParty() != null && itemAdjustment.getTaxAuthParty().contains("SGST")) {
				rate = (itemAdjustment.getAmount()/item.getAmount()) * 100;
			}
		}
		return rate;
	}
	
	*//**
	**This method is responsible to calculate the CESS rate by using CESS amount
	**//*
	static Double getCESSRate(Items item) {
		double rate = 0.0;
		List itemAdjustList = item.getItemAdjustments();
		ItemAdjustments itemAdjustment;
		for(int i=0; i<itemAdjustList.size(); i++) {
			itemAdjustment = (ItemAdjustments) itemAdjustList.get(i);
			if(itemAdjustment.getTaxAuthParty() != null && itemAdjustment.getTaxAuthParty().contains("CESS")) {
				rate = (itemAdjustment.getAmount()/item.getAmount()) * 100;
			}
		}
		return rate;
	}*/
	
}
