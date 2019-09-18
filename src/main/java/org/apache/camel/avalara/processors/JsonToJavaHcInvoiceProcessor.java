/**
 * This class convert the Json to Java object and set it to response body for HC Invoice service
 */
package org.apache.camel.avalara.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.hotwaxCommerce.dataObject.InvoiceDetails;


public class JsonToJavaHcInvoiceProcessor implements Processor {


	public void process(Exchange exchange){
		
		String output;
		output = exchange.getIn().getBody(String.class);
		System.out.println("HC Invoice Response:- \n"+output+"\n");
		InvoiceDetails invoiceDetails = InvoiceDetails.toInvoiceDetails(output);
		exchange.getIn().setBody(invoiceDetails);
		
	}

}
