package com.rainbow.tony.test.design.sproxy;

import java.util.Random;

public class Tank implements Movable {
    @Override
    public void move() {
//		long start = System.currentTimeMillis();
        System.out.println("Tank----------move  ");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//		long end = System.currentTimeMillis();
//		System.out.println("time:" + (start - end));
    }

}
