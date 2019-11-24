package com.rainbow.tony.test.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CylicBarrierTest {


    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.submit(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("A�Ѿ�����");
                barrier.await();
                System.out.println("A�����ǿ�ʼ�����");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        });
        pool.submit(() -> {
            try {
                Thread.sleep(500);
                System.out.println("B�Ѿ�����");
                barrier.await();
                System.out.println("B�����ǿ�ʼ�����");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        });
        pool.submit(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("C�Ѿ�����");
                    barrier.await();
                    System.out.println("C�����ǿ�ʼ�����");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

    }

}
