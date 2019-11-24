package com.rainbow.tony.test.concurrent;

public interface Map extends Map2 {
    @Override
    default void sayHello() {
        System.out.println("map");

    }

}
