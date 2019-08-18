package com.tony.rocketmq.namesrv.tls;

/**
 * @author tony
 * @describe TLS
 * @date 2019-08-18
 */
public class TLS {
    private static final String ACCESS_KEY = "AccessKey";
    private static final String SECRECT_KEY = "SecrectKey";
    private static final String SECURITY_TOKEN = "SecurityToken";
    private static final int MAGIC_NUMBER = 0x16;

    public static void main(String[] args) {
        System.out.println(MAGIC_NUMBER);
    }
}
