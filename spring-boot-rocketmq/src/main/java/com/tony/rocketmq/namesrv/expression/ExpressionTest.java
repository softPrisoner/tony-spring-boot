package com.tony.rocketmq.namesrv.expression;

/**
 * @author tony
 * @describe ExpressionTest
 * @date 2019-08-20
 */
public class ExpressionTest {
    public static void main(String[] args) {
        String expression = "orderId124||orderId135||orderId136";
        //split support regex
        String[] tags = expression.split("\\|\\|");
        for (String tag : tags) {
            System.out.println(tag);
        }
    }
}
