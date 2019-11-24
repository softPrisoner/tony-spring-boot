package com.rainbow.tony.test.webservice.example;

import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.message.Message;

import javax.xml.ws.Endpoint;
import java.util.List;

public class EndPointTest {
    public static void main(String[] args) {
        System.out.println("Web Service Test");
        String address = "http://127.0.0.1:9090/web-service-sei/hellows";
        Endpoint endPoint = Endpoint.publish(address, new HelloServiceImpl());
        EndpointImpl endpointImpl = (EndpointImpl) endPoint;
        List<Interceptor<? extends Message>> inInterceptors = endpointImpl.getInInterceptors();
        inInterceptors.add(new LoggingInInterceptor());
        List<Interceptor<? extends Message>> outFaultInterceptors = endpointImpl.getOutFaultInterceptors();
        outFaultInterceptors.add(new LoggingOutInterceptor());
        System.out.println(endPoint);
        System.out.println("web Service test finished");
    }

}
