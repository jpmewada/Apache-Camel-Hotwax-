/**
 * This class convert the Json to Java object and set it to response body for Eway Bill
 */
package org.apache.camel.avalara.processors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JsonToJavaEwayBillProcessor implements Processor {


	public void process(Exchange exchange){
		
		List<Map<String, Object>> outputList = new ArrayList<Map<String, Object>>();
		String output = exchange.getIn().getBody(String.class);
		System.out.println("EwayBill Response:- \n"+output);
		JSONParser parser = new JSONParser();
		try {
			JSONArray jsonArray = (JSONArray) parser.parse(output);
			for(int n = 0; n < jsonArray.size(); n++)
			{	
				Map<String, Object> outPutMap = new HashMap<String, Object>();
				JSONObject json = (JSONObject)jsonArray.get(n);
				outPutMap.put("Status code", 200);
				outPutMap.put("transactionId", (Long) json.get("TransactionId"));
				outPutMap.put("error", json.get("Errors").toString());
				JSONObject ewayBillOutput = (JSONObject)json.get("EwayBillOutput");
				outPutMap.put("Eway_bill_id", (String)ewayBillOutput.get("Eway_bill_id"));
				outPutMap.put("Eway_bill_date", (String)ewayBillOutput.get("Eway_bill_date"));
				outPutMap.put("Eway_bill_valid_upto", (String)ewayBillOutput.get("Eway_bill_valid_upto"));
				outputList.add(outPutMap);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		exchange.getIn().setBody(outputList);
	}

}
