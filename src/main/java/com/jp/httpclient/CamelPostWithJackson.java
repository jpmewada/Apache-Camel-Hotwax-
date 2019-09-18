package com.jp.httpclient;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.component.jackson.JacksonDataFormat;

import com.jp.routers.CreateEmployeeProcessor;
import com.jp.routers.Employee;

public class CamelPostWithJackson {
	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.setTracing(true);
		context.addRoutes(new RouteBuilder() {
			JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Employee.class);
			@Override
			public void configure() throws Exception {
				System.out.println("-------Start of RouteBuilder-----------");
				// route for REST POST Call
				from("direct:start").process(new CreateEmployeeProcessor()).marshal(jsonDataFormat)
						.setHeader(Exchange.HTTP_METHOD, simple("POST")).setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
						.to("http://dummy.restapiexample.com/api/v1/create")
						.process(new Processor() {
							
							public void process(Exchange exchange) throws Exception {
								System.out.println(exchange.getIn().getBody(String.class));
							}
						}
					);
				
				//from("file:/home/jaiprakash/Jaiprakash/camel").to("file:/home/jaiprakash/Jaiprakash/jp").end();
				
				
				System.out.println("-------End of RouteBuilder-----------");
				
				
			}
		}
		);
		context.start();
		ProducerTemplate prodTemp = context.createProducerTemplate();
		prodTemp.sendBody("direct:start", "Hello");
		ConsumerTemplate consTemp = context.createConsumerTemplate();
		String msg = consTemp.receiveBody("seda:end", String.class);
		System.out.println(msg);
		//Thread.sleep(Long.MAX_VALUE);
		
	}
}
