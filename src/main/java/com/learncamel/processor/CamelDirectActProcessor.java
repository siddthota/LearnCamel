package com.learncamel.processor;

import org.apache.camel.Exchange;

/**
 * Created by siddu on 11/1/2017.
 */
public class CamelDirectActProcessor implements org.apache.camel.Processor {

    public void process(Exchange exchange) throws Exception {

        try{

            String oldValue = (String) exchange.getIn().getBody();
            System.out.println("What's the oldValue: " + oldValue);

            String newValue = oldValue.replace(",", ":");
            System.out.println("The value of newValue: " + newValue);

            exchange.getIn().setBody(newValue);

        }catch(Exception e) {
            System.out.println("Exception value is: " + e);
        }

    }
}
