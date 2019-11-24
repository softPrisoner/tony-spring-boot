package com.rainbow.tony.shiro.test.arch;

import org.apache.shiro.config.Ini;
import org.junit.Test;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * ini配置文件解析原理
 *
 * @author tony
 * @describe IniTest
 * @date 2019-09-06
 */
public class IniTest {
    @Test
    public void testJavaExplorePath() {
        //最底层还是文件读写操作
        File file = new File(".");
        try {
            //CanonicalPath
            String parentPath = file.getCanonicalPath();
            String classPathBase = parentPath + "/src/main/java/";
            String classPath1 = classPathBase + "resources";
            File classPathFile = new File(classPath1);
            String fileName = "";
            File[] files = classPathFile.listFiles();
            if (null != files) {
                doFiles(files, fileName);
            }
            //abs path
            String currentPath = file.getAbsolutePath();
            //usrDir
            String userDir = System.getProperty("user.dir");
            System.out.println(userDir);
            System.out.println(currentPath);
            System.out.println(parentPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //doFile解析ini文件;
    @SuppressWarnings("unused")
    public InputStream doFiles(File[] files, String expr) throws IOException {
        for (File file : files) {
            //判断文件存在,并且不为空,
            if (null == file || !file.exists()) {
                return null;
            }
            if (file.getName().equals(expr)) {
                String fileMetaData = file.getCanonicalPath() + file.getName();
                return new FileInputStream(fileMetaData);
            } else {
                if (file.getCanonicalPath().equals(expr.substring(0, expr.lastIndexOf("/")))) {
                    File[] childFiles = file.listFiles();
                    if (childFiles != null) {
                        //递归调用,可能会发送stack flow exception
                        doFiles(childFiles, expr);
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        //不是从path下面去加载文件数据
        String iniPath = "classpath:/shiro/shiro.ini";
        String iniContent = "[users]\r\nzhang=123\n\nwang=123\n";
        Scanner scanner = new Scanner(iniContent);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }

        Ini ini = new Ini();
        ini.load(iniContent);
        //scanner
        Ini.Section section = ini.get("users");
        String sectionProp = section.get("zhang");
        System.out.println(sectionProp);

        StringBuffer buffer = new StringBuffer();
        //java底层主要还是通过props去读取属性,只不过ini在props的集成上封装了一层
        Properties props = new Properties();

        InputStream in = new FileInputStream("");
        InputStreamReader reader = new InputStreamReader(in);
        Scanner iniScanner = new Scanner(reader);
        while (iniScanner.hasNext()) {
            System.out.println(iniScanner.next());
        }

    }
}
