/**
 * This class is responsible to send get request and receive json response from HC token service
 * Serialization and Deserialization beween java object and Json happens in processor class.
 * Returns the output(token) of String object.
 */
package org.apache.camel.avalara.routes;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.common.HttpOperationFailedException;


public class HcTokenRoute extends RouteBuilder {

	String url;
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



	public void configure() {
		System.out.println("-------Start of HC Router-----------");
		// route for REST POST Call
		try {
		from("direct:generateToken").routeId("generateToken")
		.onException(HttpOperationFailedException.class) 
		.process(new Processor() { 
			public void process(Exchange exchange) throws Exception { 
				HttpOperationFailedException exe = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, HttpOperationFailedException.class);
				Map<String, Object> outPutMap = new HashMap<String, Object>();
				if(exe != null) {
					outPutMap.put("error", exe.getStatusText());
					outPutMap.put("Status code", Integer.toString(exe.getStatusCode()));

				}
				exchange.getIn().setBody(outPutMap);
			} 
		}).handled(true)
		.end()
		//.setHeader(Exchange.HTTP_METHOD, simple("GET")).setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		//.setHeader(Exchange.HTTP_QUERY, simple("USERNAME="+userName+"&PASSWORD="+password))
		.to(url)
		.process(jsonToJavaProcessor)
		.end();
		}catch(Exception e) {
			e.printStackTrace();
		}

		System.out.println("-------End of HC Router-----------");
	}
}
