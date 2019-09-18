/**
 * 
 */
package org.apache.camel.avalara;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.avalara.ewayBill.dataObject.EwayBillRequest;
import org.apache.camel.avalara.ewayBill.dataObject.Invoice;
import org.apache.camel.avalara.processors.*;
import org.apache.camel.avalara.routes.AvalaraRoute;
import org.apache.camel.avalara.routes.HcInvoiceRoute;
import org.apache.camel.avalara.routes.HcTokenRoute;
import org.apache.camel.avalara.txnapi.dataObject.GstIn;
import org.apache.camel.avalara.txnapi.dataObject.GstInList;
import org.apache.camel.avalara.utils.AvalaraUtils;
import org.apache.camel.hotwaxCommerce.dataObject.InvoiceDetails;
import org.apache.camel.impl.DefaultCamelContext;


public class CamelService {


	static CamelContext context = new DefaultCamelContext();
	static ProducerTemplate prodTemp;
	static String hcToken = null;
	static String baseUrl = null;
	
	static {
		baseUrl = "hc-qa.hotwax.co";
		try {
			context.setTracing(true);
			prodTemp = context.createProducerTemplate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<HashMap<String, Object>> invokeAvalaraTxn(GstInList gstInListObject) throws Exception {

		GstIn gstIn = (GstIn)gstInListObject.getGstInList().get(0);
		String url = "https://sandbox-gstapi.trustfilegst.in/api/v1/taxpayers/"+ gstIn.getGSTIN()+ "/transactions";
		String apiKey = "308491923f4027c7055a829746736481789647d0171340f516e081645412ba50";
		String startPointUri = "TxnApi";
		
		AvalaraRoute myRoute = new AvalaraRoute();
		myRoute.setStartPointUri(startPointUri);
		myRoute.setUrl(url);
		myRoute.setJavaToJsonProcessor(new JavaToJsonTxnProcessor());
		myRoute.setJsonToJavaProcessor(new JsonToJavaTxnProcessor());
		
		context.addRoutes(myRoute);
		//context.start();

		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put(Exchange.HTTP_METHOD, "POST");
		headers.put(Exchange.CONTENT_TYPE, "application/json");
		headers.put("Authorization", "Bearer " + apiKey);
		List<HashMap<String, Object>> msg = (ArrayList<HashMap<String, Object>>)prodTemp.requestBodyAndHeaders("direct:"+startPointUri, gstInListObject, headers);
		System.out.println(msg);
		//Thread.sleep(Long.MAX_VALUE);
		//context.stop();
		return msg;
	}

	public static List<HashMap<String, Object>> callAvalaraTxnApi() throws Exception {
		
		List<HashMap<String, Object>> msg;
		InvoiceDetails invoiceDetails = null;
		context.start();
		if(hcToken == null) {
			hcToken = invokeHcTokenGenerate(baseUrl, "admin", "hotwax@786");
		}
		invoiceDetails = invokeHcInvoice(baseUrl);
		
		if(invoiceDetails.get_error_message_() != null) {
			msg = new ArrayList<HashMap<String, Object>>();
			hcToken = invokeHcTokenGenerate(baseUrl, "admin", "hotwax@786");
			invoiceDetails = invokeHcInvoice(baseUrl);
			if(invoiceDetails.get_error_message_() != null) {
				Map<String, Object> outPutMap = new HashMap<String, Object>();
				outPutMap.put("error", "Retrieve invoice service failed");
				msg.add((HashMap<String, Object>) outPutMap);
				return msg;
			}
		}
		
		GstInList gstInList = new GstInList();
		AvalaraUtils.populateTxnRequest(gstInList, invoiceDetails);
		msg = invokeAvalaraTxn(gstInList);
		//Thread.sleep(Long.MAX_VALUE);
		context.stop();
		return msg;
	}
	
	public static List<HashMap<String, Object>> callAvalaraEwayBillApi() throws Exception {
		
		List<HashMap<String, Object>> msg;
		InvoiceDetails invoiceDetails = null;
		context.start();
		if(hcToken == null) {
			hcToken = invokeHcTokenGenerate(baseUrl, "admin", "hotwax@786");
		}
		invoiceDetails = invokeHcInvoice(baseUrl);
		
		if(invoiceDetails.get_error_message_() != null) {
			msg = new ArrayList<HashMap<String, Object>>();
			hcToken = invokeHcTokenGenerate(baseUrl, "admin", "hotwax@786");
			invoiceDetails = invokeHcInvoice(baseUrl);
			if(invoiceDetails.get_error_message_() != null) {
				Map<String, Object> outPutMap = new HashMap<String, Object>();
				outPutMap.put("error", "Retrieve invoice service failed");
				msg.add((HashMap<String, Object>) outPutMap);
				return msg;
			}
		}
		EwayBillRequest ewayBillRequest = new EwayBillRequest();
		AvalaraUtils.populateEwayBillRequest(ewayBillRequest, invoiceDetails);
		msg = invokeEwayBillApi(ewayBillRequest);
		//Thread.sleep(Long.MAX_VALUE);
		context.stop();
		return msg;
	}
	
	public static List<HashMap<String, Object>> invokeEwayBillApi(EwayBillRequest ewayBillRequest) throws Exception {

		Invoice invoice = (Invoice)ewayBillRequest.getInvoiceList().get(0);
		String url = "https://sandbox-gstapi.trustfilegst.in/api/v1/taxpayers/"+ invoice.getGSTIN()+ "/ewayTransactions";
		String apiKey = "3ea3c0ad2f54bd08f13389ac2f3ad6256b99747bc1d5901c43ad59a8bd2269f8";
		String startPointUri = "ewayBill";

		AvalaraRoute myRoute = new AvalaraRoute();
		myRoute.setStartPointUri(startPointUri);
		myRoute.setUrl(url);
		myRoute.setJavaToJsonProcessor(new JavaToJsonEwayBillProcessor());
		myRoute.setJsonToJavaProcessor(new JsonToJavaEwayBillProcessor());
		
		context.addRoutes(myRoute);
		//context.start();

		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put(Exchange.HTTP_METHOD, "POST");
		headers.put(Exchange.CONTENT_TYPE, "application/json");
		headers.put("Authorization", "Bearer " + apiKey);
		List<HashMap<String, Object>> msg = (ArrayList<HashMap<String, Object>>)prodTemp.requestBodyAndHeaders("direct:"+startPointUri, ewayBillRequest, headers);
		System.out.println(msg);
		//Thread.sleep(Long.MAX_VALUE);
		//context.stop();
		return msg;
	}
	
	public static InvoiceDetails invokeHcInvoice(String baseUrl) throws Exception {

		String url = "https://"+baseUrl+"/api/b2c/invoices";
		
		HcInvoiceRoute hcInvoiceRoute = new HcInvoiceRoute();
		hcInvoiceRoute.setUrl(url);
		hcInvoiceRoute.setJsonToJavaProcessor(new JsonToJavaHcInvoiceProcessor());
		
		context.addRoutes(hcInvoiceRoute);

		//InvoiceDetails invoiceDetails = (InvoiceDetails)prodTemp.requestBody("direct:invoice", "");
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put(Exchange.HTTP_METHOD, "GET");
		headers.put(Exchange.CONTENT_TYPE, "application/json");
		headers.put("Authorization", "Bearer " + hcToken);
		InvoiceDetails invoiceDetails = (InvoiceDetails)context.createProducerTemplate().requestBodyAndHeaders("direct:invoice", "", headers);
		context.stopRoute("invoice");
		context.removeRoute("invoice");
		return invoiceDetails;
	}

	public static String invokeHcTokenGenerate(String baseUrl, String userName, String password) throws Exception {
		String token = "";
		String url = "https://"+baseUrl+"/api/getAuthenticationToken";
		
		HcTokenRoute hcTokenRoute = new HcTokenRoute();
		hcTokenRoute.setUrl(url);
		hcTokenRoute.setJsonToJavaProcessor(new JsonToJavaHcTokenProcessor());
		
		context.addRoutes(hcTokenRoute);
		
		//token = (String)prodTemp.requestBody("direct:generateToken", "");
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put(Exchange.HTTP_METHOD, "GET");
		headers.put(Exchange.CONTENT_TYPE, "application/json");
		headers.put(Exchange.HTTP_QUERY, "USERNAME="+userName+"&PASSWORD="+password);
		Map<String, Object> tokenMap = (HashMap<String, Object>)prodTemp.requestBodyAndHeaders("direct:generateToken", "", headers);
		if(tokenMap.get("Status code").equals(200)) {
			token = (String)tokenMap.get("token");
		}
		context.stopRoute("generateToken");
		context.removeRoute("generateToken");
		System.out.println("Token Generated from HC: "+token);

		return token;

	}
	
}
