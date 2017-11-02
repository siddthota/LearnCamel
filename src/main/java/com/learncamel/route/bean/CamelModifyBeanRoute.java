package com.learncamel.route.bean;

import com.learncamel.processor.CamelBean;
import org.apache.camel.builder.RouteBuilder;


public class CamelModifyBeanRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("direct:beanInput")
                .bean(new CamelBean(), "map")
                .log("Received Message is ${body} and Headers are ${headers}")
                .to("mock:beanoutput");

    }
}
