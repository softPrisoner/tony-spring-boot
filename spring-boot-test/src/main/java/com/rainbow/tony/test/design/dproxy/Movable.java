package com.rainbow.tony.test.design.dproxy;

public interface Movable {
    void move();

    void stop(String a);

    void shoot(Integer a, Movable b);
}
