package com.rainbow.tony.activiti.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tony
 * @describe TransactionModel
 * @date 2019-08-28
 */
@Data
@Accessors(chain = true)
@ToString
public class TransactionModel implements Serializable {
    private long id;
    private String name;
    private double balance;
    private Date createTime;
}
