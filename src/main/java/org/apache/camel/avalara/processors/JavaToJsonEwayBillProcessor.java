/**
 * This class convert the Java object to Json and set it to request body for Eway Bill
 */
package org.apache.camel.avalara.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.avalara.ewayBill.dataObject.EwayBillRequest;

public class JavaToJsonEwayBillProcessor implements Processor {

	public void process(Exchange exchange) {
		try {
			EwayBillRequest exchangeEwayBillRequest = exchange.getIn().getBody(EwayBillRequest.class);
			String request = exchangeEwayBillRequest.toJson();
			System.out.println("EwayBill Request:- \n" + request);
			exchange.getIn().setBody(request);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
