/**
 * This class convert the Json to Java object and set it to response body for HC Invoice service
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


public class JsonToJavaTxnProcessor implements Processor {


	public void process(Exchange exchange){
		
		List<Map<String, Object>> outputList = new ArrayList<Map<String, Object>>();
		String output = exchange.getIn().getBody(String.class);
		System.out.println("Response:- \n"+output);
		JSONParser parser = new JSONParser();
		try {
			JSONArray jsonArray = (JSONArray) parser.parse(output);
			for(int n = 0; n < jsonArray.size(); n++)
			{	
				Map<String, Object> outPutMap = new HashMap<String, Object>();
				JSONObject json = (JSONObject)jsonArray.get(n);
				outPutMap.put("transactionId", (Long) json.get("TransactionId"));
				outPutMap.put("error", json.get("Errors").toString());
				outPutMap.put("Status code", 200);
				outputList.add(outPutMap);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		exchange.getIn().setBody(outputList);
	}

}
