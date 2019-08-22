package com.rainbow.tony.test.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 事件驱动SAX
 */
public class SAXParserHandler extends DefaultHandler {
    private Book book = null;
    private String value = null;
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // TODO Auto-generated method stub
        super.startElement(uri, localName, qName, attributes);

        // 判断元素名称
        if (qName.equals("book")) {
            // 通过属性名获取属性
            book = new Book();
            String id = attributes.getValue("id");
            System.out.println("book的属性值:" + id);
            // 创建book对象
            // 设置属性id
            book.setId(id);
//			int num = attributes.getLength();
//			for (int i = 0; i < num; i++) {
//				System.out.print("book元素的第" + (i + 1) + "个属性名是" + attributes.getQName(i));
//				System.out.println("----属性值是:" + attributes.getValue(i));
//
//			}
        }
        if (!qName.equals("book") && !qName.equals("bookstore")) {
            System.out.print("属性名:" + qName + "---------------");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // 调用DefaultHandler的endElement方法
        super.endElement(uri, localName, qName);
        if (qName.equals("book")) {
            if (book != null) {
                books.add(book);
                System.out.println(book);
            }
        } else if (qName.equals("name")) {
            book.setName(value);
        } else if (qName.equals("author")) {
            book.setAuthor(value);
        } else if (qName.equals("publisher")) {
            book.setPublisher(value);
        } else if (qName.equals("price")) {
            book.setPrice(value);
        }
    }

    //用来标识解析开始
    @Override
    public void setDocumentLocator(Locator locator) {
        System.out.println("SAX解析开始");
        super.setDocumentLocator(locator);
    }

    //用来标识解析结束
    @Override
    public void endDocument() throws SAXException {
        System.out.println("SAX解析结束");
        super.endDocument();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // TODO Auto-generated method stub
        super.characters(ch, start, length);
        value = new String(ch, start, length);
        if (!value.trim().equals("")) {
            System.out.println("属性值:------" + value);
        }

    }

}
