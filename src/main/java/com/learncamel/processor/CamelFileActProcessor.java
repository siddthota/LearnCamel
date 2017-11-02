package com.learncamel.processor;

import org.apache.camel.Exchange;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CamelFileActProcessor implements org.apache.camel.Processor {

        String newValue = "";
        public void process(Exchange exchange) throws Exception {
            File file = new File((String) exchange.getIn().getHeaders().get("CamelFilePath"));
            System.out.println("What's on file: " + file);

            String readFromFile = null;

            if(file != null) {

                FileReader file1 = new FileReader(file);
                System.out.println("What's on file1: " + file1);
                BufferedReader readFile = new BufferedReader(file1);
                System.out.println("What's on readFile: " + readFile);

                while((readFromFile = readFile.readLine()) != null) {
                    System.out.println("ReadFromFile is: " + readFromFile);

                    String oldValue = readFromFile;
                    System.out.println("What's on oldValue: " + oldValue);

                    newValue = newValue.concat(oldValue.replace(",", ":")).concat("\n");
                    System.out.println("What's on newValue: " + newValue);

                    exchange.getIn().setBody(newValue);
                }
            }
        }
}
