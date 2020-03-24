package com.tony.java8.stream;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author tony
 * @description MapTest
 * @copyright rainbow
 * @date 2020/03/24
 */
public class MapTest {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length).collect(toList());
        System.out.println(JSON.toJSONString(wordLengths));
    }

}
