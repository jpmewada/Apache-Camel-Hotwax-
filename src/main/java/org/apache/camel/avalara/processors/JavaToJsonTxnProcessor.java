/**
 * This class convert the Java object to Json and set it to request body for Transaction API(Avalara)
 */
package org.apache.camel.avalara.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.avalara.txnapi.dataObject.GstInList;


public class JavaToJsonTxnProcessor implements Processor {

	public void process(Exchange exchange) {
		try {
			GstInList exchangeGstInList = exchange.getIn().getBody(GstInList.class);
			String request = exchangeGstInList.toJson();
			System.out.println("Request:- \n" + request);
			exchange.getIn().setBody(request);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
