package com.jp.httpclient;


import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelGet {
	public static void main(String[] args) {
	    CamelContext context = new DefaultCamelContext();

	    try {
	        ProducerTemplate template = context.createProducerTemplate();
	        context.start();

	        Exchange exchange = template
	                .request(
	                        "http://dummy.restapiexample.com/api/v1/employee/330",
	                        new Processor() {
	                            public void process(Exchange exchange)
	                                    throws Exception {
	                            }
	                        });

	        if (null != exchange) {
	            Message out = exchange.getOut();
	            System.out.println(out.getBody().toString());
	            int responseCode = out.getHeader(Exchange.HTTP_RESPONSE_CODE,
	                    Integer.class);
	            System.out.println("Response: " + String.valueOf(responseCode));
	        }

	        Thread.sleep(1000 * 3);
	        context.stop();
	    } catch (Exception ex) {
	        System.out.println("Exception: " + ex);
	    }

	    System.out.println("DONE!!");
	} 
}
