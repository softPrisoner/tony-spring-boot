package com.rainbow.tony.test.design.dproxy;

import java.io.*;

public class MyClassLoader extends ClassLoader {
    private String name;
    private String path = "d:\\";
    private final String fileType = ".class";

    public MyClassLoader(String name) {
        super();
        this.name = name;
    }

    public MyClassLoader(ClassLoader parent, String name) {
    }

    public String toString() {
        return this.name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private byte[] loadClassData(String name) {

        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            this.name = this.name.replace(".", "\\");
            is = new FileInputStream(new File(path + name + fileType));
            int ch;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            try {
                is.close();
                baos.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }
        return data;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);
        this.defineClass(name, data, 0, data.length);
        return null;
    }

    public static void main(String[] args) {
        MyClassLoader loader1 = new MyClassLoader("loader1");
        loader1.setPath("d:\\myapp\\serverlib\\");
        MyClassLoader loader2 = new MyClassLoader(loader1, "loader2");
        loader2.setPath("d:\\myapp\\clientlib\\");
        MyClassLoader loader3 = new MyClassLoader(null, "loader3");
    }

    public static void testClass(ClassLoader loader) throws Exception {
        Class<?> clazz = loader.loadClass("Test");
        Object newInstance = clazz.newInstance();

    }
}
