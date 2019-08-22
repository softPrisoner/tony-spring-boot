package com.rainbow.tony.test.design.dproxy;

import java.lang.reflect.Method;

public interface InvocationHandler {
    Object invoke(Object obj, Method m) throws Exception;
}
