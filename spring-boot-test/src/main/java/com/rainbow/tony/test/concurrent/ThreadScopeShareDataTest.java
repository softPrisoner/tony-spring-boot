package com.rainbow.tony.test.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadScopeShareDataTest {
    private static int data = 0;
    private static Map<Thread, Integer> dataMap = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
//					ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
//					Executors.newCachedThreadPool();
//					Executors.newSingleThreadExecutor();
                data = new Random().nextInt();
                System.out.println(Thread.currentThread().getName() + "has put a new value " + data);
                dataMap.put(Thread.currentThread(), data);
                new A().get();
                new B().get();
                try {
                    Thread.sleep(500);
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
            int data = dataMap.get(Thread.currentThread());
            System.out.println(Thread.currentThread().getName() + "A has gotten a value" + data);
            return data;
        }
    }

    static class B {
        public int get() {
            int data = dataMap.get(Thread.currentThread());
            System.out.println(Thread.currentThread().getName() + "B has gotten a value" + data);
            return data;
        }
    }
}
