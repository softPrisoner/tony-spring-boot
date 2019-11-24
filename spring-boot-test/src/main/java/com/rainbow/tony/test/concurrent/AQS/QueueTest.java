package com.rainbow.tony.test.concurrent.AQS;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> msg = new LinkedBlockingQueue<>();
        String a = "124";
        msg.add(a);
        String take = msg.take();
        System.out.println(take + "   " + msg.isEmpty());
    }
}
