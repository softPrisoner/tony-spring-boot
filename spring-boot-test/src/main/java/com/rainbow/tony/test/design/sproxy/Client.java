package com.rainbow.tony.test.design.sproxy;

public class Client {
    public static void main(String[] args) {
        Movable m = new Tank();
        TankTimeProxy p = new TankTimeProxy(m);
        TankLogProxy l = new TankLogProxy(p);
        l.move();
    }
}
