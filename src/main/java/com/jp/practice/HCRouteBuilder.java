package com.jp.practice;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.common.HttpOperationFailedException;

public class HCRouteBuilder extends RouteBuilder {

    @Override
    public void configure(){

        onException(Exception.class)
                .handled(true)
                .process(new Processor() {
                    public void process(Exchange exchange){
                        Exception exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
                        System.out.println(exception);


                        HttpOperationFailedException httpException = (HttpOperationFailedException) exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
                        exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, httpException.getStatusCode());
                        String responseCode = exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE, String.class);
                        exchange.getIn().setBody(responseCode);
                    }
                });

        from("direct:start")
                .setHeader(Exchange.HTTP_METHOD,simple("GET"))
                .setHeader(Exchange.HTTP_QUERY, simple("?USERNAME=admin&PASSWORD=hotwax@786"))
                .to("https://hc-qa.hotwax.co/api/getAuthenticationToken");

        from("direct:invoice")
                .setHeader(Exchange.HTTP_METHOD,simple("GET"))
                .process(new Processor() {
                    public void process(Exchange exchange) {
                        String token = exchange.getIn().getHeader("Authorization", String.class);
                        System.out.println(token);
                        //exchange.getIn().setBody(exchange.getIn().getBody(String.class));
                    }
                })
                //.setHeader("Authorization",simple(token))
                .to("https://hc-qa.hotwax.co/api/b2c/invoices");
    }
}
