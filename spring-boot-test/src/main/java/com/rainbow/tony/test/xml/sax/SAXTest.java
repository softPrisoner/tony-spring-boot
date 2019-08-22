package com.rainbow.tony.test.xml.sax;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SAXTest {
    public ArrayList<Book> parseXml() {
        //SAX解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //SAX解析器
        SAXParser saxParser;
        SAXParserHandler handler = null;
        try {
            saxParser = factory.newSAXParser();
            // handler封装大量节点信息及转换对象
            handler = new SAXParserHandler();
            saxParser.parse("bookstore.xml", handler);
            for (int i = 0; i < handler.getBooks().size(); i++) {
                System.out.println("第" + (i + 1) + "本书:" + handler.getBooks().get(i));
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assert handler != null;
        return (ArrayList<Book>) handler.getBooks();
    }

    //通过对象创建xml文件
    public void createXml() throws TransformerConfigurationException {
        ArrayList<Book> books = parseXml();
        SAXTransformerFactory tff = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        TransformerHandler handler = tff.newTransformerHandler();
        Transformer tf = handler.getTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        File f = new File("newbook.xml");
        try {
            if (!f.exists()) {
                boolean success = f.createNewFile();
                if (success) {
                    System.out.println("Create File success");
                } else {
                    System.out.println("Create File failed");
                }
            }
            //设置结果集合
            Result result = new StreamResult(new FileOutputStream(f));
            handler.setResult(result);
            handler.startDocument();
            //属性集合实现
            AttributesImpl atts = new AttributesImpl();
            handler.startElement("", "", "bookstore", atts);
            //遍历添加子元素
            for (Book book : books) {
                //清空原来属性设置
                atts.clear();
                //设置book的id属性
                atts.addAttribute("", "", "id", "", book.getId());
                handler.startElement("", "", "book", atts);
                atts.clear();
                handler.startElement("", "", "name", atts);
                atts.clear();
                handler.characters(book.getName().toCharArray(), 0, book.getName().length());
                handler.endElement("", "", "name");
                handler.startElement("", "", "author", atts);
                atts.clear();
                handler.characters(book.getAuthor().toCharArray(), 0, book.getAuthor().length());
                handler.endElement("", "", "author");
                handler.startElement("", "", "publisher", atts);
                atts.clear();
                handler.characters(book.getPublisher().toCharArray(), 0, book.getPublisher().length());
                handler.endElement("", "", "publisher");
                handler.startElement("", "", "price", atts);
                atts.clear();
                handler.characters(book.getPrice().toCharArray(), 0, book.getPrice().length());
                handler.endElement("", "", "price");
                handler.endElement("", "", "book");
            }
            //根元素结束标签
            handler.endElement("", "", "bookstore");
            //文档结束标签
            handler.endDocument();
        } catch (SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        SAXTest sax = new SAXTest();
        sax.createXml();
    }
}