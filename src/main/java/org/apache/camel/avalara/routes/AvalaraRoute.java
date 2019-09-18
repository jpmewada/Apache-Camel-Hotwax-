/**
 * This class is responsible to send request and receive json response from external system(Avalara)
 * It takes the input of Java object.
 * Serialization and Deserialization between java object and Json happens in processor class.
 * Returns the output of Java object.
 */
package org.apache.camel.avalara.routes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.common.HttpOperationFailedException;


public class AvalaraRoute extends RouteBuilder{

	String startPointUri;
	String url;
	Processor javaToJsonProcessor;
	Processor jsonToJavaProcessor;

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the javaToJsonProcessor
	 */
	public Processor getJavaToJsonProcessor() {
		return javaToJsonProcessor;
	}

	/**
	 * @param javaToJsonProcessor the javaToJsonProcessor to set
	 */
	public void setJavaToJsonProcessor(Processor javaToJsonProcessor) {
		this.javaToJsonProcessor = javaToJsonProcessor;
	}

	/**
	 * @return the jsonToJavaProcessor
	 */
	public Processor getJsonToJavaProcessor() {
		return jsonToJavaProcessor;
	}

	/**
	 * @param jsonToJavaProcessor the jsonToJavaProcessor to set
	 */
	public void setJsonToJavaProcessor(Processor jsonToJavaProcessor) {
		this.jsonToJavaProcessor = jsonToJavaProcessor;
	}

	public String getStartPointUri() {
		return startPointUri;
	}

	public void setStartPointUri(String startPointUri) {
		this.startPointUri = startPointUri;
	}

	public void configure() {
		System.out.println("-------Start of Router-----------");
		// route for REST POST Call
		try {
		from("direct:"+startPointUri).routeId(startPointUri)
		.onException(HttpOperationFailedException.class) 
		.process(new Processor() { 
			public void process(Exchange exchange) throws Exception { 
				HttpOperationFailedException exe = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, HttpOperationFailedException.class);
				String responseCode;
				String responseText;
				List<Map<String, Object>> outputList = new ArrayList<Map<String, Object>>();
				if(exe != null) {
					Map<String, Object> outPutMap = new HashMap<String, Object>();
					responseCode = Integer.toString(exe.getStatusCode());
					responseText = exe.getStatusText();
					outPutMap.put("error", responseText);
					outPutMap.put("response", exe.getResponseBody());
					outPutMap.put("Status code", responseCode);
					outputList.add(outPutMap);

				}
				
				
				exchange.getIn().setBody(outputList);
			} 
		}).handled(true)
		.end()
		.process(javaToJsonProcessor)
		//.setHeader(Exchange.HTTP_METHOD, simple(method)).setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		//.setHeader("Authorization", simple("Bearer "+ apiKey))
		.to(url)
		.process(jsonToJavaProcessor)
		.end();
		}catch(Exception e) {
			e.printStackTrace();
		}

		System.out.println("-------End of Router-----------");
	}
}
