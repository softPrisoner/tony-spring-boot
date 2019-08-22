package com.rainbow.tony.test.design.dproxy;

import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {
    @Override
    public Object invoke(Object obj, Method m) throws Exception {
        System.out.println("Tank start....");
        m.invoke(m, (Object) null);
        System.out.println("Tank stop....");
        return null;
    }

}
