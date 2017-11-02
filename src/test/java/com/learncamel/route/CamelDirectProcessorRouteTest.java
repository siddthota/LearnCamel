package com.learncamel.route;

import com.learncamel.route.direct.CamelDirectProcessorRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelDirectProcessorRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder() throws Exception {
        return new CamelDirectProcessorRoute();
    }

    @Test
    public void processorTest() {

        String output = (String) template.requestBody("direct:processorInput", "Sid,123,11Sep2017");
        System.out.println("What's in output: " + output);

        String expected = "Sid:123:11Sep2017";

        assertEquals(expected, output);
    }
}
