package com.rainbow.tony.test.webservice.publiser;

import java.util.List;

import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.message.Message;

public class myPubliser {
    public static void main(String[] args) {
        System.out.println("WebService Test");
        String address = "http://192.168.1.116:9090/web-service-sei/hellows";
        Endpoint publish = Endpoint.publish(address, new mySEIImpl());
        EndpointImpl endpointImpl = (EndpointImpl) publish;
        List<Interceptor<? extends Message>> inInterceptors = endpointImpl.getInInterceptors();
        inInterceptors.add(new CheckUserInterceptor());
        System.out.println("WebService Test");
    }
}
