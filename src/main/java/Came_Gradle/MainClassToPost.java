package Came_Gradle;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

public class MainClassToPost {
    public static void main (String args[]){
        SimpleRouteBuilderToPost simpleRouteBuilderToPost = new SimpleRouteBuilderToPost();
        CamelContext ctx = new DefaultCamelContext();
        try {
            ctx.addRoutes(simpleRouteBuilderToPost);
            ctx.start();
            Employee emp = new Employee();
            emp.setAge(20);
            emp.setName("Jaip1");
            emp.setSalary(200);
            ProducerTemplate producerTemplate = ctx.createProducerTemplate();
            producerTemplate.requestBody("direct:start", emp);

            Thread.sleep(5 * 60 * 1000);
            ctx.stop();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
