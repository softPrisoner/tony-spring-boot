package com.rainbow.tony.test.design.dproxy;

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

    @Override
    public void stop(String a) {
        // TODO Auto-generated method stub
    }

    @Override
    public void shoot(Integer a, Movable b) {
        // TODO Auto-generated method stub
    }
}
