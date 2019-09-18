/**
 * This class is responsible to send get request and receive json response from HC Invoice service.
 * Serialization and Deserialization between java object and Json happens in processor classes.
 * Returns the output of Java object.
 */
package org.apache.camel.avalara.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.hotwaxCommerce.dataObject.InvoiceDetails;
import org.apache.camel.http.common.HttpOperationFailedException;


public class HcInvoiceRoute extends RouteBuilder {

	String url;
	Processor jsonToJavaProcessor;

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
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
	 * @param jsonToJavaProcessor
	 *            the jsonToJavaProcessor to set
	 */
	public void setJsonToJavaProcessor(Processor jsonToJavaProcessor) {
		this.jsonToJavaProcessor = jsonToJavaProcessor;
	}

	public void configure() {
		System.out.println("-------Start of HC Invoice Router-----------");
		// route for REST POST Call
		try {
			from("direct:invoice").routeId("invoice")
			.onException(HttpOperationFailedException.class)
			.process(new Processor() {
				public void process(Exchange exchange) throws Exception {
					HttpOperationFailedException exe = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, HttpOperationFailedException.class);
					InvoiceDetails invoiceDetails = new InvoiceDetails();
					invoiceDetails.set_error_message_(Integer.toString(exe.getStatusCode()));

					exchange.getIn().setBody(invoiceDetails);
				}
			}).handled(true).end()
			//.setHeader(Exchange.HTTP_METHOD, simple("GET"))
			//.setHeader(Exchange.CONTENT_TYPE, constant("application/json")) 			//Alternatively, we can set the headers with this code also.
			//.setHeader("Authorization", simple("Bearer " + apiKey))
			//.setHeader(Exchange.HTTP_QUERY, simple("filters={invoiceDate_fld0_value=${in.header.date}, invoiceDate_fld0_op=greaterThanEqualTo}"))
			.to(url)
			.process(jsonToJavaProcessor)
			.end();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("-------End of HC Invoice Router-----------");
	}
}
