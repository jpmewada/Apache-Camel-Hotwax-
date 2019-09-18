package Came_Gradle;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilderToPost extends RouteBuilder {


    @Override
    public void configure() throws Exception {

        // route for REST GET Call
        from("direct:start")
                .process(new Processor(){
                    public void process(Exchange exchange) throws Exception {
                        Employee emp = (Employee)exchange.getIn().getBody(Employee.class);
                        String json = emp.toJson();
                        exchange.getIn().setBody(json);
                        System.out.println("request: "+exchange.getIn().getBody(String.class));
                    }
                })
                .setHeader(Exchange.HTTP_METHOD, simple("POST"))
                .setHeader("Content-Type",constant("application/json"))
                .to("http://dummy.restapiexample.com/api/v1/create").process(new Processor(){
            public void process(Exchange exchange) throws Exception {
                System.out.println("response: "+exchange.getIn().getBody(String.class));
            }
        });
    }
}