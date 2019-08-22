package com.rainbow.tony.test.xml.dom4j;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class DOM4JTest {
    // DOM4J创建xml
    public void createXml() {
        // 创建文档。一气呵成
        Document document = DocumentHelper.createDocument();
        // 通过迭代的方式来显示元素层次
        // <rss>
        Element rss = document.addElement("rss");
        // <rss version="2.0">
        rss.addAttribute("version", "2.0");
        // rss:channel
        Element channel = rss.addElement("channel");
        // channel:title
        Element title = channel.addElement("title");
        // channel:title=
        title.setText("国内最新新闻");
        // 输出格式化,createPrettyPrint()
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        File file = new File("rss.xml");
        // write out
        XMLWriter writer;
        try {
            // 基本上还是通过输出流写入磁盘的
            writer = new XMLWriter(new FileOutputStream(file), format);
            // 设置是否转义,设置不转义flase,默认为转义true;
            writer.setEscapeText(false);
            // 将文件写到指定地址
            writer.write(document);
            writer.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    // DOM4J进行xml解析
    public void xmlParse() {

        SAXReader reader = new SAXReader();
        try {
            // 读取xml并转换成文档对象
            File xmlFile = new File("bookstore.xml");
            Document document = reader.read(xmlFile);
            // 获取第一个迭代元素,根元素
            Element bookStore = document.getRootElement();
            // 迭代直接子元素
            Iterator<Element> it = bookStore.elementIterator();
            while (it.hasNext()) {
                System.out.println("---------------------------------");
                Element book = it.next();
                List<Attribute> bookAttr = book.attributes();
                for (Attribute attr : bookAttr) {
                    String name = attr.getName();
                    String value = attr.getValue();
                    System.out.println(name + "     " + value);
                }
                Iterator<Element> element = book.elementIterator();
                while (element.hasNext()) {
                    Element node = element.next();
                    String name = node.getName();
                    String text = node.getText();
                    System.out.println(name + "   " + text);
                }
                System.out.println("---------------------------------");
            }
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DOM4JTest dom4j = new DOM4JTest();
        dom4j.createXml();
    }
}
