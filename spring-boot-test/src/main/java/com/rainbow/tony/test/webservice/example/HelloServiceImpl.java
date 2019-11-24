package com.rainbow.tony.test.webservice.example;

import javax.jws.WebService;
import java.io.Serializable;

@WebService
public class HelloServiceImpl implements HelloService, Serializable {
    @Override
    public String sayHello(String name) {
        System.out.println("name:--" + name);
        return "hello" + name;
    }
}
