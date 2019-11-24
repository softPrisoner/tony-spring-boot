package com.rainbow.tony.test.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalShareDataTest {
    private static ThreadLocal<Integer> local = new ThreadLocal<>();

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.submit(() -> {
            new A().get();
        });
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                int data = new Random().nextInt();
                System.out.println(Thread.currentThread().getName() + "has put a new value " + data);
                local.set(data);
                try {
                    Thread.sleep(500);
                    new A().get();
                    new B().get();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }).start();

        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    static class A {
        public int get() {
            int data = local.get();
            System.out.println(Thread.currentThread().getName() + "A has gotten a value" + data);
            return data;
        }
    }

    static class B {
        public int get() {
            System.out.println(this);
            int data = local.get();
            System.out.println(Thread.currentThread().getName() + "B has gotten a value" + data);
            return data;
        }
    }
}
