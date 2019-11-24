package com.tony.common.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ManHandler implements InvocationHandler {
    private Object obj;

    public ManHandler(Object obj) {
        // TODO Auto-generated constructor stub
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(obj, null);
        after();
        return null;
    }

    public void before() {
        System.out.println("proxy before");
    }

    public void after() {
        System.out.println("proxy after");
    }
}
