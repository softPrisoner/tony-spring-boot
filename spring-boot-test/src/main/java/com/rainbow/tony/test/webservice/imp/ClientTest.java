package com.rainbow.tony.test.webservice.imp;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.message.Message;

import java.util.List;

@SuppressWarnings("deprecation")
public class ClientTest {
    public static void main(String[] args) {
        /**ͨSSL
         *MySEIImplService
         * Client client = ClientProxy.getClient(mySEIImplPort);
         *
         * */
        MySEIImplService factory = new MySEIImplService();
        MySEIImpl mySEIImplPort = factory.getMySEIImplPort();
        Client client = ClientProxy.getClient(mySEIImplPort);
        System.out.println(client);
        List<Interceptor<? extends Message>> inInterceptors = client.getInInterceptors();
        inInterceptors.add(new LoggingInInterceptor());
        List<Interceptor<? extends Message>> outInterceptors = client.getOutInterceptors();
        outInterceptors.add(new AddUserInterceptor("lihua", "123456"));
        System.out.println(mySEIImplPort.getClass());
        mySEIImplPort.sayHello("hello");

    }
}
