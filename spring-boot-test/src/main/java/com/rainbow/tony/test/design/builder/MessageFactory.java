package com.rainbow.tony.test.design.builder;

public class MessageFactory {

    public static Message createMail() {
        return new Mail();
    }

    public static Message createMsg() {
        return new Msg();
    }
}
