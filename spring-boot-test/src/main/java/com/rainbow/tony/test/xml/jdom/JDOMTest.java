package com.rainbow.tony.test.xml.jdom;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JDOMTest {
    public static void main(String[] args) {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("bookstore.xml");
        InputStream in = null;
        try {
            in = new FileInputStream(xmlFile);
            Document document = builder.build(in);
            Element root = document.getRootElement();
            List<Element> bookList = root.getChildren();
            for (Element book : bookList) {
                List<Element> bookChildren = book.getChildren();
                for (Element bookChild : bookChildren) {
                    String name = bookChild.getName();
                    String value = bookChild.getValue();
                    System.out.println(name + " " + value);
                }
                List<Attribute> attributes = book.getAttributes();
                for (Attribute atr : attributes) {
                    System.out.println(atr.getName() + "==" + atr.getValue());
                }
            }
        } catch (IOException | JDOMException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }

    }
}
