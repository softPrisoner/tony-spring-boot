package com.rainbow.tony.test.xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class DOMTest {
    private DocumentBuilder getDocumentBuilder() {
        // 创建一个DocumentBuilderFactory的实例
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        // 创建一个DocumentBuilder对象
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return db;
    }

    public void createXml() {
        //通过getDocumentBuilder()方法接受DocumentBuilder对象
        DocumentBuilder db = getDocumentBuilder();
        Document document = db.newDocument();
        //用来标记是否是一个独立的xml,默认是yes。
        //如果是no表示这个XML不是独立的而是依赖于外部定义的一个DTD。
        document.setXmlStandalone(true);// #69行tf.setOutputProperty(OutputKeys.INDENT, "yes");
        Element bookstore = document.createElement("bookstore");
        //<book></book>
        Element book = document.createElement("book");
        book.setAttribute("id", "1");
        //<name></name>
        Element name = document.createElement("name");
        book.setTextContent("汤姆索亚历险记");
        book.appendChild(name);
        //<author><author>
        Element author = document.createElement("author");
        book.appendChild(author);
        //<publisher></publisher>
        Element publisher = document.createElement("publisher");
        book.appendChild(publisher);
        //<price></price>
        Element price = document.createElement("price");
        book.appendChild(price);
        bookstore.appendChild(book);
        document.appendChild(bookstore);
        //通过TransformerFactory获取TransformerFactory实例
        TransformerFactory tff = TransformerFactory.newInstance();
        try {
            //通过TransformerFactory获取Transformer实例
            Transformer tf = tff.newTransformer();
            //设置输出格式setOutputProperty
            //OutputKeys.*定义格式
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.transform(new DOMSource(document), new StreamResult(new File("book1.xml")));
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void xmlParse() {
        try {
            // 进行文件解析
            Document doc = getDocumentBuilder().parse("bookstore.xml");
            // 通过标签名获取标签对象
            NodeList bookList = doc.getElementsByTagName("book");
            /**
             * 在不知道元素的情況下获取<book>标签中的属性及属性值
             */
            // 通过nodeList的getLength()方法可以获取bookList的长度
            for (int i = 0; i < bookList.getLength(); i++) {
                // 获取一个book节点
//			Node attrs = bookList.item(i);
//			NamedNodeMap bookAttrs = attrs.getAttributes();
//			System.out.println("第" + (i + 1) + "书" + "共有" + bookAttrs.getLength() + "个属性");
//			for (int j = 0; j < bookAttrs.getLength(); j++) {
//				Node attr = bookAttrs.item(j);
//				String nodeName = attr.getNodeName();
//				System.out.print("属性名:"+nodeName);
//				String nodeValue = attr.getNodeValue();
//				System.out.println("属性值:"+nodeValue);
//			}
                /**
                 * 1.通过getElementByTagName获取节点信息
                 * 2.通过节点信息获取节点属性，并将Node强制转换成Element
                 * 3.通过获取的属性信息获取属性名及属性值
                 *
                 */
                Element book = (Element) bookList.item(i);
//			String attr = ele.getAttribute("id");
                NodeList childNodes = book.getChildNodes();
                System.out.println("第" + (i + 1) + "个属性共有" + childNodes.getLength() + "个子节点");
                for (int k = 0; k < childNodes.getLength(); k++) {
                    if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
//					System.out.println(childNodes.item(k).getNodeName()+"   "+childNodes.item(k).getFirstChild().getNodeValue());
                        System.out.println(childNodes.item(k).getNodeName() + "   " +
                                childNodes.item(k).getTextContent());
                    }
                }
            }
        } catch (SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DOMTest test = new DOMTest();
        test.createXml();
    }

}
