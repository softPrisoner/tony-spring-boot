package com.tony.java8.lamda.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author tony
 * @description Transaction
 * @copyright rainbow
 * @date 2020/03/21
 */
@Data
@AllArgsConstructor
@ToString
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
}
