package com.rainbow.tony.test.webservice.publiser;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface mySEI {
    @WebMethod
    String sayHello(String name);

}
