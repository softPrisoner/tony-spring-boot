package com.rainbow.tony.test.design.builder;

public class Msg implements Message {

    @Override
    public void send(String s) {
        System.out.print("send message" + s);

    }

}
