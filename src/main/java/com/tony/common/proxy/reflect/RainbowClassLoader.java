package com.tony.common.proxy.reflect;

/**
 * @author tony
 * @describe RainbowClassLoad
 * @date 2019-08-23
 */
public class RainbowClassLoader extends ClassLoader {
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        //在加载数据之前可以处理,加载类之前通过aop改变数据库密码
        //敏感类加载中
        if (null != name && name.contains("bootstrap")) {
            return null;
        }
        return super.loadClass(name, resolve);
    }
}
