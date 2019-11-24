package com.rainbow.tony.test.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {
    private static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.submit(() -> {
            String a = "abc";
            System.out.println(Thread.currentThread().getName() + "������" + a);
            try {
                while (true) {
                    String exchange = exchanger.exchange(a);
                    System.out.println(Thread.currentThread().getName() + exchange);
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        });
        pool.submit(new Runnable() {

            @Override
            public void run() {
                String a = "efg";
                System.out.println(Thread.currentThread().getName() + "������" + a);
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                try {
                    while (true) {
                        String exchange = exchanger.exchange(a);
                        System.out.println(Thread.currentThread().getName() + exchange);
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
    }

}
