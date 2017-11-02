package com.learncamel.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import java.io.File;

/**
 * Created by siddu on 11/1/2017.
 */
public class CamelFileProcessorRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder() throws Exception {
        return new CamelFileProcessorRoute();
    }

    @Test
    public void processorTest() throws Exception {

        String expected = "Sid:123:11Sep2017\n" +
                "Ship:221:16Nov2017\n" +
                "Sun:325:27Oct2017\n";
        MockEndpoint mock = getMockEndpoint("mock:newoutput");
        mock.expectedBodiesReceived(expected);

        Thread.sleep(3000);

        File file = new File("data/newoutput");

        assertTrue(file.isDirectory());
        assertEquals(1, file.listFiles().length);

        assertMockEndpointsSatisfied();

    }

}
