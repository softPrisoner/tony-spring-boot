package com.rainbow.tony.test.design.builder;

public class Test {
    public static void main(String[] args) {
        Message createMail = MessageFactory.createMail();
        Message createMsg = MessageFactory.createMsg();
        createMail.send("abc");
        createMsg.send("123");
    }
}
