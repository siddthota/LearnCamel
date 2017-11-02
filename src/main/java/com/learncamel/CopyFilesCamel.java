package com.learncamel;


import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesCamel{

    public static void main(String[] args) {
        CamelContext context = new DefaultCamelContext();

        try {
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:data/input?noop=true")
                            //.log("Received Massage is ${body} and headers are ${headers}")
                            .to("log:?level=INFO&showBody=true&showHeaders=true")
                            .to("file:data/output")
                            .to("file:data/anothetdestination");

                    from("file:data/input1?noop=true")
                            .log("Received Massage is ${body} and headers are ${headers}")
                            .to("file:data/nextoutput");
                }
            });

            context.start();
            Thread.sleep(3000);
            context.stop();
        } catch(Exception e) {
            System.out.println("Exception Details: " + e);
        }
    }
}
