package com.rainbow.tony.test.webservice.example;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloService {
    @WebMethod
    String sayHello(String name);
}
