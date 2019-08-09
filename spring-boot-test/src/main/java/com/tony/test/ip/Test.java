package com.tony.test.ip;

/**
 * @author tony
 * @describe Test
 * @date 2019-08-09
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(IPConverter.IP2Long("192.168.4.1"));
        System.out.println(IPConverter.Long2IP(3232246645L));
    }
}
