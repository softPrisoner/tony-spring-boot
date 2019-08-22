package com.rainbow.tony.test.ip;

import java.util.StringTokenizer;

/**
 * @author tony
 * @describe IPConverter
 * @date 2019-08-09
 */
public class IPConverter {

    /**
     * Ipv4地址转换成长整型地址
     */
    public static long IP2Long(String ipStr) {
        long result = 0;
        StringTokenizer tokenizer = new StringTokenizer(ipStr, ".");
        result += Long.parseLong(tokenizer.nextToken()) << 24;
        result += Long.parseLong(tokenizer.nextToken()) << 16;
        result += Long.parseLong(tokenizer.nextToken()) << 8;
        result += Long.parseLong(tokenizer.nextToken());
        return result;
    }

    /**
     * 长整型IP地址转换成
     */
    public static String Long2IP(long ipLong) {
        StringBuilder sb = new StringBuilder();
        sb
                .append(ipLong >>> 24).append(".")
                .append(((ipLong & 0x00FFFFFF) >>> 16)).append(".")
                .append((ipLong & 0x0000FFFF) >>> 8).append(".")
                .append(ipLong & 0x000000FF);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(IPConverter.IP2Long("192.168.4.1"));
        System.out.println(IPConverter.Long2IP(3232246645L));
    }

}
