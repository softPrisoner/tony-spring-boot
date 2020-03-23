package com.tony.java8.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @author tony
 * @description SortTest
 * @copyright rainbow
 * @date 2020/03/23
 */
public class SortTest {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("a", "b", "A", "B");
        //with lambda
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        //Method reference
        str.sort(String::compareToIgnoreCase);
    }

}
