package com.rainbow.tony.test.webservice.imp;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.namespace.QName;
import java.util.List;

public class AddUserInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
    private String username;
    private String password;

    public AddUserInterceptor(String username, String password) {
        super(Phase.PRE_PROTOCOL);
        this.username = username;
        this.password = password;
        // TODO Auto-generated constructor stub
    }

    @Override
    public void handleMessage(SoapMessage msg) throws Fault {
        List<Header> header = msg.getHeaders();
        // DOMUtils.createDocument()
        Document document = DOMUtils.createDocument();
        //<atguigu></atguigu>
        Element rootEle = document.createElement("atguigu");
        //<name></name>
        Element nameEle = document.createElement("name");
        //<name></name>
        nameEle.setTextContent(username);
        //<name>liduodong</name><atguigu></atguigu>
        rootEle.appendChild(nameEle);
        Element pswEle = document.createElement("password");
        pswEle.setTextContent(password);
        rootEle.appendChild(pswEle);
        document.appendChild(rootEle);
        header.add(new Header(new QName("atguigu"), document));
    }

}
