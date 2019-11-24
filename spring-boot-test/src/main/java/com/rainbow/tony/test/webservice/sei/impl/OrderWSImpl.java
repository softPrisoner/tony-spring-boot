package com.rainbow.tony.test.webservice.sei.impl;

import com.rainbow.tony.test.webservice.bean.Order;
import com.rainbow.tony.test.webservice.sei.OrderWS;

import javax.jws.WebService;

@WebService
public class OrderWSImpl implements OrderWS {
    @Override
    public Order getOrderById(int id) {
        System.out.println("server getOrderById" + id);
        return new Order(id, "ƻ��", 15.8);
    }
}
