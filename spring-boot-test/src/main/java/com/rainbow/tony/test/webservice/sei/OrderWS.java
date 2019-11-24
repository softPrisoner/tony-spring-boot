package com.rainbow.tony.test.webservice.sei;

import com.rainbow.tony.test.webservice.bean.Order;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface OrderWS {
	@WebMethod
	public Order getOrderById(int id);
}
