package com.rainbow.tony.test.design.dproxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.net.URLClassLoader;

public class Proxy {
    public static final String rt = "\r\n";

    public static Object newProxyInstance(Class<?>[] interfaces, InvocationHandler h) throws Exception {

        String methodStr = "";
        String interfaceStr = "";
        for (Class<?> interf : interfaces) {
            interfaceStr += interf.getName() + ",";
            Method[] methods = interf.getDeclaredMethods();

            for (Method m : methods) {
                Parameter[] parameters = m.getParameters();
                methodStr += rt +
                        "@Override" + rt +
                        "public " + m.getReturnType() + " " + m.getName() + "( ";
                for (Parameter p : parameters) {
                    methodStr += p.getParameterizedType().getTypeName() + " " + p.getName() + ",";
                }
                methodStr = methodStr.substring(0, methodStr.length() - 1);
                methodStr += " ) " +
                        "{" + rt +
                        "		try{" + rt +
                        Method.class.getName() + " md=" + interf.getName()
                        + ".class.getMethod(\"" + m.getName() + "\");" + rt +
                        "h.invoke(this, md);" + rt +
                        "}catch(" + Exception.class.getName() + " e){" + rt +
                        "e.printStackTrace();" + rt +
                        "			}" + rt;
                methodStr += TypeGeneratorValue.match(m) + rt + "    }" + rt;
            }
        }
        interfaceStr = interfaceStr.substring(0, interfaceStr.length() - 1);
        String src = "package com.rainbow.tony.dynamic.proxy;" + rt +
                "public class TankTimeProxy implements " + interfaceStr + " {" + rt +
                "    private " + InvocationHandler.class.getName() + " h;" + rt +
                "    public TankTimeProxy(" + InvocationHandler.class.getName() + " h) {" + rt +
                "       this.h = h;" + rt +
                "    }" + rt
                + methodStr + rt +
                "  }";
        String fileName = System.getProperty("user.dir") + "/src/main/java/com/rainbow/tony/dynamic/proxy/TankTimeProxy.java";
        return compile(fileName, src, h);
    }

    private static Object compile(String fileName, String src, InvocationHandler h) throws Exception {
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(src);
        fw.flush();
        fw.close();
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
        Iterable units = fileMgr.getJavaFileObjects(fileName);
        CompilationTask task = compiler.getTask(null, fileMgr, null, null, null, units);
        task.call();
        fileMgr.close();
        URL[] urls = new URL[]{new URL("file:/" + System.getProperty("user.dir") + "/src")};
        URLClassLoader loader = new URLClassLoader(urls);
        Class<?> c = loader.loadClass("com.rainbow.tony.dynamic.proxy.TankTimeProxy");
        System.out.println(c);
        //Movable t=(Movable)c.newInstance();
        Constructor<?> ctr = c.getConstructor(InvocationHandler.class);
        return ctr.newInstance(h);

    }
}
