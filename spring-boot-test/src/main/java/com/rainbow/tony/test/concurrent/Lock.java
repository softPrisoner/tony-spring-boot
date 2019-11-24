package com.rainbow.tony.test.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Lock {
    private static ReentrantLock lock = new ReentrantLock();

    private static Integer i = 0;

    public static void setA() {
        Condition condition = lock.newCondition();
        try {
            condition.await();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        System.out.println(lock.getHoldCount());
        condition.notify();
//		synchronized (i.getClass()) {
        i++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "    " + i);
//		}
    }

    public static void setB() {
        synchronized (i.getClass()) {
            i++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "    " + i);
        }
    }

    public static void main(String[] args) throws Exception {
//		ExecutorService pool = Executors.newCachedThreadPool();
//		ExecutorService pool = Executors.newSingleThreadExecutor();
//	ExecutorService pool = Executors.newFixedThreadPool(3);
        ExecutorService pool = Executors.newScheduledThreadPool(3, new ThreadFactory() {

            @Override
            public Thread newThread(Runnable r) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return new Thread(Lock::setA);
            }
        });
        //callable return value
        Future<Integer> submit = pool.submit(() -> 1 + 2);
        Integer integer = submit.get();
        System.out.println(integer);
        for (int i = 0; i < 20; i++) {
            pool.submit(() -> {
                setA();
                setB();
            });
        }
        pool.shutdown();
    }
}
