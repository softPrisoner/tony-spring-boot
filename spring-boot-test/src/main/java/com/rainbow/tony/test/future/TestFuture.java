package com.rainbow.tony.test.future;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tony
 * @describe TestFuture
 * @date 2019-09-02
 */
public class TestFuture {

    //    private volatile int state;
//    private static final int NEW          = 0;
//    private static final int COMPLETING   = 1;
//    private static final int NORMAL       = 2;
//    private static final int EXCEPTIONAL  = 3;
//    private static final int CANCELLED    = 4;
//    private static final int INTERRUPTING = 5;
//    private static final int INTERRUPTED  = 6;
    @Test
    @SuppressWarnings("unchecked")
    public void testNormal() throws ExecutionException, InterruptedException {
        //future task test
        //future task最底层实现了 Runnable, Future<V> 即具备线程的作用,又具备执行回调返回值的作用
        FutureTask futureTask = new FutureTask((Callable<String>) () -> "hello world!");
        futureTask.cancel(true);
        futureTask.run();
        String result = (String) futureTask.get();
        if (futureTask.isDone()) {
            System.out.println("任务已经完成了" + "返回值:" + result);
        }

    }

    @Test
    @SuppressWarnings("unchecked")
    public void testException() throws ExecutionException, InterruptedException {
        //future task test
        //future task-> Runnable, Future<V> 即具备线程的作用,又具备执行回调返回值的作用
        FutureTask futureTask = new FutureTask((Callable<String>) () -> {
            Thread.sleep(5000);
            throw new Exception("i'm a exception");
        });
        futureTask.run();
        String result = (String) futureTask.get();
        if (futureTask.isDone()) {
            System.out.println("任务已经完成了" + "返回值:" + result);
        }

    }

    @Test
    @SuppressWarnings("unchecked")
    public void testCancel() throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask((Callable<String>) () -> "hello world!");
        futureTask.cancel(true);
        futureTask.run();
        //actually the thread state === INTERRUPTING 5 cause by cancel(true)
        if (futureTask.isCancelled()) {
            System.out.println("Task has been cancel");
        } else {
            String result = (String) futureTask.get();
            if (futureTask.isDone()) {
                System.out.println("任务已经完成了" + "返回值:" + result);
            }
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testRunMoreOnce() throws ExecutionException, InterruptedException {
        AtomicInteger count = new AtomicInteger();
        final FutureTask futureTask = new FutureTask(() -> {
            count.getAndIncrement();
            return count.get() + "";
        });
        //测试多次执行还是一次执行
        futureTask.run();
        futureTask.run();
        futureTask.run();
        futureTask.run();
        //actually the thread state === INTERRUPTING 5 cause by cancel(true)
        String result = (String) futureTask.get();
        if (futureTask.isDone()) {
            System.out.println("任务已经完成了" + "返回值:" + result);
        }
    }
}
