package com.rainbow.tony.test.future;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author tony
 * @describe TestFuture
 * @date 2019-09-02
 */
public class TestFuture {


    @Test
    public void test() throws ExecutionException, InterruptedException {
        //future task test
        //future task最底层实现了 Runnable, Future<V> 即具备线程的作用,又具备执行回调返回值的作用
        FutureTask futureTask = new FutureTask(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello world!";
            }
        });
        futureTask.run();
        String result = (String) futureTask.get();
        if (futureTask.isDone()) {
            System.out.println("任务已经完成了" + "返回值:" + result);
        }

    }
}
