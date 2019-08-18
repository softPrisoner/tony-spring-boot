package com.tony.rocketmq.namesrv.flag;

/**
 * @author tony
 * @describe FlagTest
 * @date 2019-08-18
 */
public class FlagTest {
    public static void main(String[] args) {
        int rpc_oneway=1;
        int flag=0;
       int bits=1<<rpc_oneway;
        flag|=bits;
        System.out.println(flag);
    }
}
