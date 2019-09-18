package com.jp.httpclient;


import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import com.jp.routers.Employee;

public class CamelPostWithGson {
	
	//public static final Logger logger = Logger.getLogger(CamelPostWithGson.class);
	
	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.setTracing(true);
		context.addRoutes(new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				System.out.println("-------Start of RouteBuilder-----------");
				// route for REST POST Call
				from("direct:start").process(new Processor() {

					public void process(Exchange exchange) throws Exception {
						Employee emp = new Employee("Sneh24", 5000, 30);
						exchange.getIn().setBody(emp.toJson());
					}

				})
				.setHeader(Exchange.HTTP_METHOD, simple("POST")).setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
				.to("http://dummy.restapiexample.com/api/v1/create")
				.process(new Processor() {

					public void process(Exchange exchange) throws Exception {
						String output = exchange.getIn().getBody(String.class);
						System.out.println(output);
						Employee employee = Employee.toEmployee(output);
						exchange.getIn().setBody(employee);
					}
				})
				.to("seda:end");

				//from("file:/home/jaiprakash/Jaiprakash/camel").to("file:/home/jaiprakash/Jaiprakash/jp").end();


				System.out.println("-------End of RouteBuilder-----------");


			}
		}
				);
		context.start();
		ProducerTemplate prodTemp = context.createProducerTemplate();
		prodTemp.sendBody("direct:start", "Hello");
		ConsumerTemplate consTemp = context.createConsumerTemplate();
		Employee msg = consTemp.receiveBody("seda:end", Employee.class);
		System.out.println(msg.toString());
		//Thread.sleep(Long.MAX_VALUE);

	}
	
}
