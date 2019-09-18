/**
 * This class fetch the token from response and set it to response body
 */
package org.apache.camel.avalara.processors;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JsonToJavaHcTokenProcessor implements Processor {


	public void process(Exchange exchange){
		
		Map<String, Object> outPutMap = new HashMap<String, Object>();
		String output = exchange.getIn().getBody(String.class).substring(2);
		System.out.println("HC token Response:- \n"+output+"\n");
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject) parser.parse(output);
			outPutMap.put("Status code", 200);
			outPutMap.put("token", (String)json.get("token"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		exchange.getIn().setBody(outPutMap);
	}

}
