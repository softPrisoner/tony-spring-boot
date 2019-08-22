package com.rainbow.tony.test.design.dproxy;

import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {
    @Override
    public Object invoke(Object obj, Method m) throws Exception {
        long start = System.currentTimeMillis();
        m.invoke(obj, new Object[]{});
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));
        return null;
    }

}
