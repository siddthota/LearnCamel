package com.learncamel.route.bean;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Created by siddu on 11/1/2017.
 */
public class CamelBeanRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyBeanRoute();
    }

    @Test
    public void beanTest() {

        String output = (String) template.requestBody("direct:beanInput", "Sid,121,11Sep2017");
        System.out.println("What's the output value: " + output);

        String expected = "Sid:121:11Sep2017";

        assertEquals(expected, output);
    }

}
