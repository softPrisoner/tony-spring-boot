package com.tony.common.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class CglibProxy {
    public static void main(String[] args) {
        Enhancer eh = new Enhancer();
        eh.setSuperclass(User.class);
        eh.setCallback(new UserInterceptor());
        User user = (User) eh.create();
        user.setAge(11);
    }

}
