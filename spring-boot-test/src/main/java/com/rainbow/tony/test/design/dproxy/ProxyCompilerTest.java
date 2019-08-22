package com.rainbow.tony.test.design.dproxy;

import com.rainbow.tony.test.design.dproxy.Movable;
import com.rainbow.tony.test.design.dproxy.Tank;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

public class ProxyCompilerTest {
    public static void main(String[] args) throws IOException {
        String rt = "\r\n";
        String src = "package com.rainbow.tony.dynamic.proxy;" + rt +
                "public class TankTimeProxy implements Movable {" + rt +
                "    private Movable t;" + rt +
                "    public TankTimeProxy(Movable t) {" + rt +
                "       this.t = t;" + rt +
                "    }" + rt +
                "    @Override" + rt +
                "    public void move() {" + rt +
                "        long start = System.currentTimeMillis();" + rt +
                "        t.move();" + rt +
                "        long end = System.currentTimeMillis();" + rt +
                "        System.out.println(\"time:\" + (end-start));" + rt +
                "    }" + rt +
                "  }";
        String fileName = System.getProperty("user.dir")
                + "/src/com/rainbow/tony/dynamic/proxy/TankTimeProxy.java";

        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(src);
        fileWriter.flush();
        fileWriter.close();
        //compiler start
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileMgr = compiler
                .getStandardFileManager(null, null, null);

        Iterable units = fileMgr.getJavaFileObjects(fileName);
        CompilationTask task = compiler
                .getTask(null, fileMgr, null, null, null, units);
        task.call();
        fileMgr.close();

        URL[] urls = new URL[]{new URL("file:/" + System.getProperty("user.dir") + "/src")};
        //class loader load class
        URLClassLoader loader = new URLClassLoader(urls);
        try {
            Class<?> c = loader.loadClass(
                    "com.rainbow.tony.dynamic.proxy.TankTimeProxy");
            System.out.println(c);
            Constructor<?> ctr = c.getConstructor(Movable.class);
            Movable t = (Movable) ctr.newInstance(new Tank());
            t.move();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
