package com.jp.practice;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


public class Main {

    public static void main(String args[]){

        HCRouteBuilder hcRouteBuilder = new HCRouteBuilder();

        CamelContext camelContext = new DefaultCamelContext();

        try{
            camelContext.addRoutes(hcRouteBuilder);
            camelContext.start();

            ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
            String jsonString = producerTemplate.requestBody("direct:start","",String.class);

            if(jsonString.startsWith("//")){
                jsonString = jsonString.substring(2);
            }

            JSONObject object = (JSONObject) JSONValue.parse(jsonString);

            /*Set<String> keySet = object.keySet();
            for (String key : keySet) {
                Object value = object.get(key);
                System.out.println(key +":"+value);
            }*/

            String token = "Bearer " +(String)object.get("token");
            System.out.println("token: "+token);

            camelContext.stopRoute("route1");
            camelContext.removeRoute("route1");

            //String invoiceDetails = producerTemplate.requestBody("direct:invoice",vendorToken,String.class);
            String invoiceDetails = producerTemplate.requestBodyAndHeader("direct:invoice","","Authorization",token, String.class);


            System.out.println("-------invoice details-----------"+invoiceDetails);

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
