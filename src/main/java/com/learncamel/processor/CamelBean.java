package com.learncamel.processor;

/**
 * Created by siddu on 11/1/2017.
 */
public class CamelBean {

    public String map(String input) {

        String newBody = input.replace(",", ":");
        System.out.println("What's the newBody value: " + newBody);
        return newBody;
    }

    public String map2(String input) {
        String newBody2 = input.replace(",", "~");
        System.out.println("What's the newBody2 value: " + newBody2);
        return newBody2;
    }
}
