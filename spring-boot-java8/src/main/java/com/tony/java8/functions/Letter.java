package com.tony.java8.functions;

/**
 * @author tony
 * @description Letter
 * @copyright rainbow
 * @date 2020/03/23
 */
public class Letter {
    public static String addHeader(String text) {
        return "From Raoul,Mario and Alan: " + text;
    }

    public static String addFooter(String text) {
        return text + "Kind regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }

}
