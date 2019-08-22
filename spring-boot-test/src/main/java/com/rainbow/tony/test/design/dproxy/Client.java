package com.rainbow.tony.test.design.dproxy;

public class Client {
    public static void main(String[] args) {
        Movable t = new Tank();
        Movable m;
        try {
            m = (Movable) Proxy.newProxyInstance(new Class<?>[]{Movable.class}, new LogHandler());
            m.move();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
