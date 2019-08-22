package com.rainbow.tony.test.design.builder;

public class Mail implements Message {

    @Override
    public void send(String s) {
        System.out.print("mail" + s);

    }

}
