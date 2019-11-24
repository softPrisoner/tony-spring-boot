package com.tony.common.proxy.reflect;

import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

/**
 * @author tony
 * @describe ClassInvokerTest
 * @date 2019-08-23
 */
public class ClassLoaderTest {

    public void useClassLoader(String className) throws ClassNotFoundException {
        ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = sysClassLoader.loadClass(className); //CLS Not Found Exception
        if (aClass == null) {
            sysClassLoader.getParent().loadClass(className);
        }
    }

    @CallerSensitive
    public static void useClassForName() throws ClassNotFoundException {
        //0 Reflect 1 CurrentClass 2 CurrentClass
        Class<?> clazz = Reflection.getCallerClass(1);
        System.out.println(clazz.getCanonicalName());

    }

    @CallerSensitive
    public static void main(String[] args) throws ClassNotFoundException {
        useClassForName();
    }
}
