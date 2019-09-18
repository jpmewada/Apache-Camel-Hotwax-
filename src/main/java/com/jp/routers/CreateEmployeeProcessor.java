package com.jp.routers;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CreateEmployeeProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        System.out.println(exchange.getIn().getBody(String.class));
    	Employee emp = new Employee("Ravi",200, 24);
		exchange.getIn().setBody(emp);
    }

}