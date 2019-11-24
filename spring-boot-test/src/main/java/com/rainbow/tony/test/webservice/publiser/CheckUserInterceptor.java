package com.rainbow.tony.test.webservice.publiser;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.frontend.FaultInfoException;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;

import javax.xml.namespace.QName;

public class CheckUserInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

    public CheckUserInterceptor() {
        super(Phase.PRE_PROTOCOL);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void handleMessage(SoapMessage msg) throws Fault {
        Header header = msg.getHeader(new QName("atguigu"));
        if (header != null) {
            Element element = (Element) header.getObject();
            String username = element.getElementsByTagName("name").item(0).getTextContent();
            String password = element.getElementsByTagName("password").item(0).getTextContent();
            ;
            if ("xiaozhang".equals(username) && "123456".equals(password)) {
                System.out.println("test tttt");
                return;
            } else
                try {
                    throw new FaultInfoException("δͨ����������");
                } catch (FaultInfoException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }

}
