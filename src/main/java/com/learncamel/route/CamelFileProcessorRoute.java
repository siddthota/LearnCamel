package com.learncamel.route;


import com.learncamel.processor.CamelFileActProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelFileProcessorRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("file:data/newinput?noop=true")
                .process(new CamelFileActProcessor())
                .log("Received Message is ${body} and Headers are ${headers}")
                .to("file:data/newoutput?fileName=newoutput.txt")
                .to("mock:newoutput");

    }
}
