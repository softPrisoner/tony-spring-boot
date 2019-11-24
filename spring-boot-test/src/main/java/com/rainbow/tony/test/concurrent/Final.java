package com.rainbow.tony.test.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Final {
    private final int a;

    public Final(int c) {
        //a = c
        a = c + c;
        System.out.println(Thread.currentThread().getName() + "----" + a);
    }

    public static void add() {
//		a++;
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 30; i++) {
            final int t = i;
            pool.submit(() -> {
                new Final(t);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });

        }

        for (int i = 0; i < 30; i++) {
            final int t = i;
            pool.submit(() -> {
                new Final(t);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        }
    }

}
