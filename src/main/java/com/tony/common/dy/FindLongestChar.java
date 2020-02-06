package com.tony.common.dy;

/**
 * @author tony
 * @describe FindLongestChar
 * @date 2019/06/17 下午 7:13
 */
public class FindLongestChar {

    public static void getLongestChar(String str) {
        int count = 0;
        char findChar = 0;
        for (int i = 0; i < str.length(); ) {
            char c = str.charAt(i);
            int k = i;
            int tempCount = 1;
            while ((k + 1) <= str.length() - 1
                    && c == str.charAt(k + 1)) {
                tempCount++;
                k++;
            }
            if (tempCount > count) {
                count = tempCount;
                findChar = c;
            }
            if (k > i) {
                i = k;
            } else {
                i++;
            }
        }
        System.out.println(count + " " + findChar);
    }

    public static void main(String[] args) {
        String str = "aaaabbccccdddceeff";
        getLongestChar(str);
    }

}
