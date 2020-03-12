package com.rainbow.tony.security.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.util.Random;

/**
 * MD5Utils
 *
 * @author tony
 * @description tool for password encrypt which avoiding the password leaked out.
 * @date 2020/01/18
 */
public class Md5Utils {
    private static final Integer SALT_LENGTH = 16;
    /**
     * Fixed string salt <也可以使用固定的盐值如“1234567890123456”,16位字符串>
     */
    @SuppressWarnings("unused")
    private static final String SOLID_SALT = "1234567890123456";

    private static final Logger LOGGER = LoggerFactory.getLogger(Md5Utils.class);

    private static final String PADDING_STR = "0";

    /**
     * byte[]字节数组 转换成 十六进制字符串
     *
     * @param arr 要转换的byte[]字节数组
     * @return String 返回十六进制字符串
     */
    private static String hex(byte[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; ++i) {
            sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100), 1, 3);
        }
        return sb.toString();
    }


    /**
     * MD5加密,并把结果由字节数组转换成十六进制字符串
     *
     * @param str 要加密的内容
     * @return String 返回加密后的十六进制字符串
     */
    private static String md5Hex(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(str.getBytes());
            return hex(digest);
        } catch (Exception e) {
            LOGGER.error("Transfer md5 hex failed caused  by{}", e.getCause());
            return "";
        }
    }

    /**
     * 生成含有随机盐的密码
     *
     * @param password 要加密的密码
     * @return String 含有随机盐的密码
     */
    public static String getSaltMd5(String password) {
        Random random = new Random();
        StringBuilder sBuilder = new StringBuilder(SALT_LENGTH);
        sBuilder.append(random.nextInt(99999999)).append(random.nextInt(99999999));
        int len = sBuilder.length();
        //Append zero to 16
        if (len < SALT_LENGTH) {
            for (int i = 0; i < SALT_LENGTH - len; i++) {
                sBuilder.append(PADDING_STR);
            }
        }

        String salt = sBuilder.toString();
        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return String.valueOf(cs);
    }

    /**
     * 验证加盐后是否和原密码一致
     *
     * @param password 原密码
     * @param password 加密之后的密码
     * @return boolean true表示和原密码一致 false表示和原密码不一致
     */
    public static boolean getSaltVerifyMd5(String password, String md5str) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];

        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5str.charAt(i);
            cs1[i / 3 * 2 + 1] = md5str.charAt(i + 2);
            cs2[i / 3] = md5str.charAt(i + 1);
        }
        String saltStr = new String(cs2);
        return md5Hex(password + saltStr).equals(String.valueOf(cs1));
    }

    public static void main(String[] args) {
        String plaintext = "qewqe2342";
        String cipherText = Md5Utils.getSaltMd5(plaintext);
        System.out.println("加盐后MD5:" + cipherText);
        System.out.println("是否是同一字符串:" + Md5Utils.getSaltVerifyMd5(plaintext, "a89209b4191639ae87d9f76be6ca5e67279a601670b9f808"));
    }
}