package com.tony.spring.exam;

import java.util.ArrayList;
import java.util.List;

public class Main5 {
    static int result = 0;
    static int step = 0;

    static int string2int(String str) {

        List<Integer> resultList = new ArrayList<Integer>();
        //截取整数
        if (str.indexOf(".") != -1&&str.lastIndexOf(".")==str.indexOf(".")) {
            int end = str.indexOf(".");
            str = str.substring(0, end);
        }
        int strLength = str.length();
        if (strLength == 1 && str.charAt(0) == 48) {
            return 0;
        }
        for (int i = 0; i < strLength; i++) {

            char numChar = str.charAt(i);
            int target = numChar - 48;
            if (target < 0 || target > 9) {
                return 0;
            }
            resultList.add(target);
        }
        step = resultList.size()-1; //比如说5
        resultList.stream().forEach(number -> {
            result += number * Math.pow(10, step);
            step--;
        });
        return result;
    }

    public static void main(String[] args) {
        int result = string2int("0360");
        System.out.println(result);
    }
}
