package com.rainbow.tony.test.design.sproxy;

public class TankLogProxy implements Movable {
    public TankLogProxy(Movable t) {
        super();
        this.t = t;
    }

    Movable t;

    @Override
    public void move() {
        System.out.println("Tank start....");
        t.move();
        System.out.println("Tank stop....");
    }
}
