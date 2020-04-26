package com.tony.mybatis.test;

/**
 * @author tony
 * @description Test
 * @copyright rainbow
 * @date 2020/04/26
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("@" + System.lineSeparator() + "@");

        System.out.println(long.class);
        System.out.println(Long.class);

        //In action,it will be boxed.
        Class<Long> clz1 = long.class;
        Class<Long> clz2 = Long.class;
    }
}
