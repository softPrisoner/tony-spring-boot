package com.rainbow.tony.test.design.sproxy;

public class TankTimeProxy implements Movable {
    private Movable t;

    public TankTimeProxy(Movable t) {
        this.t = t;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        t.move();
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));
    }

}
