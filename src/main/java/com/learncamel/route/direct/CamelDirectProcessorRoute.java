package com.learncamel.route.direct;


import com.learncamel.processor.CamelDirectActProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelDirectProcessorRoute extends RouteBuilder {

    public void configure() throws Exception{
        from("direct:processorInput")
                .process(new CamelDirectActProcessor())
                .log("Received Message is ${body} and Headers are ${headers}")
                .to("mock:directoutput");
    }
}
