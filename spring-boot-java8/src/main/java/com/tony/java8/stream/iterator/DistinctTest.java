package com.tony.java8.stream.iterator;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tony
 * @description DistinctTest
 * @copyright rainbow
 * @date 2020/03/24
 */
public class DistinctTest {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        List<Integer> distinctList = numberList.stream().distinct().collect(Collectors.toList());
        System.out.println(JSON.toJSONString(distinctList, true));
        numberList.stream()
                .filter(item -> item > 1).skip(2).collect(Collectors.toList());
        numberList.stream()
                .limit(2).collect(Collectors.toList());
    }

}
