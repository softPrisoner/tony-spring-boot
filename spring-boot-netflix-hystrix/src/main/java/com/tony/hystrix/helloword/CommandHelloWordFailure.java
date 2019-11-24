package com.tony.hystrix.helloword;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tony
 * @describe CommandHelloWordFailure
 * @date 2019-11-10
 */
public class CommandHelloWordFailure extends HystrixCommand<String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandHelloWorld.class);
    private final String name;

    public CommandHelloWordFailure(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("example group"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        throw new RuntimeException("this command always exit");
    }

    @Override
    protected String getFallback() {
        return getFallbackMethodName();
    }

    @Override
    protected String getFallbackMethodName() {
        return "fallback";
    }


    public static class UnitTest {
        @Test
        public void test() {
            String test = new CommandHelloWordFailure("test").execute();
            System.out.println(test);
        }
    }
}
