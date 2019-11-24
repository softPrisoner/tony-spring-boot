package com.tony.common.proxy.cglib;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserInterceptor implements net.sf.cglib.proxy.MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] params, MethodProxy proxy) throws Throwable {
        System.out.println("before invoke ");
        Object result = proxy.invoke(obj, params);
        System.out.println("after invoke");
        return result;
    }

}
