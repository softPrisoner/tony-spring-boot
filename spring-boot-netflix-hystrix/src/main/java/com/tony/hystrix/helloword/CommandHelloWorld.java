package com.tony.hystrix.helloword;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.Observer;

import java.util.concurrent.ExecutionException;

/**
 * @author tony
 * @describe CommandHelloWorld
 * @date 2019-11-10
 */
public class CommandHelloWorld extends HystrixCommand<String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandHelloWorld.class);
    private final String name;

    public CommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("example group"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        LOGGER.error("run");
        return "Hello " + name;
    }


    public static class UnitClass {
        @Test
        public void testSynchronous() {
            Assert.assertEquals("Hello World", new CommandHelloWorld("World").execute());
            Assert.assertEquals("Hello Tony", new CommandHelloWorld("Tony").execute());
        }

        @Test
        public void testSynchronous1() throws ExecutionException, InterruptedException {
            Assert.assertEquals("Hello World", new CommandHelloWorld("World").queue().get());
            Assert.assertEquals("Hello Tony", new CommandHelloWorld("Tony").queue().get());
        }

        @Test
        public void testObservable() {
            //blocking
            Observable<String> observable1 = new CommandHelloWorld("World").observe();
            Observable<String> observable2 = new CommandHelloWorld("Tony").observe();
            Assert.assertEquals("Hello World", observable1.toBlocking().single());
            Assert.assertEquals("Hello Tony", observable2.toBlocking().single());

            //non-blocking
            observable1.subscribe(new Observer<String>() {
                @Override
                public void onCompleted() {
                    LOGGER.info("task1 finish");
                }

                @Override
                public void onError(Throwable e) {
                    LOGGER.error("task1 error");
                }

                @Override
                public void onNext(String value) {
                    System.out.println("task1 value:" + value);
                }
            });

            //non-blocking
            observable1.subscribe(new Observer<String>() {
                @Override
                public void onCompleted() {
                    LOGGER.info("task2 finish");
                }

                @Override
                public void onError(Throwable e) {
                    LOGGER.error("task2 error");
                }

                @Override
                public void onNext(String value) {
                    System.out.println("task2 value:" + value);
                    throw new RuntimeException("task runtime exception");
                }
            });
            //non-blocking
            observable1.subscribe(new Observer<String>() {
                @Override
                public void onCompleted() {
                    LOGGER.info("task3 finish");
                }

                @Override
                public void onError(Throwable e) {
                    LOGGER.error("task3 error");
                }

                @Override
                public void onNext(String value) {
                    System.out.println("task3 value:" + value);

                }
            });
            //action non-blocking
            observable2.subscribe(System.out::println);
        }

        @Test
        public void testObservable2() {
            //blocking
            Observable<String> observable1 = new CommandHelloWorld("World").observe();
            Observable<String> observable2 = new CommandHelloWorld("Tony").toObservable();
        }
    }
}
