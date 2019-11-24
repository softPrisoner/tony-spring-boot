package com.rainbow.tony.test.webservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@ToString
public class Order {
    private long id;
    private String name;
    private double price;
}
