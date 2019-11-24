package com.tony.common.proxy.jdk;

import java.lang.reflect.Proxy;

public class JdkProxyTest {
	public static Object get(Object obj) {
		ManHandler handler = new ManHandler(obj);
		Object objProxy = Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[] { Man.class }, handler);
		return objProxy;

	}

	public static void main(String[] args) throws ClassNotFoundException {
		Man zhangsan = new NamedMan();
		Man lisi = (Man) JdkProxyTest.get(zhangsan);
		lisi.findObject();

	}

}
