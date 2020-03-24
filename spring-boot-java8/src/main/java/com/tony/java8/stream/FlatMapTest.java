package com.tony.java8.stream;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author tony
 * @description FlatMapTest
 * @copyright rainbow
 * @date 2020/03/24
 */
public class FlatMapTest {
    public static void main(String[] args) {
        String[] arrayOfWords = {"Goodbye", "World"};
        //Transfer array to stream
        Stream<String> streamWords1 = Arrays.stream(arrayOfWords);
        Stream<String> streamWords2 = Arrays.stream(arrayOfWords);
        List<Stream<String>> mapList = streamWords1.map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());
        String jsonString1 = JSON.toJSONString(mapList);
        System.out.println(jsonString1);

        List<String> flatMapList = streamWords2.map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct().collect(toList());
        String jsonString2 = JSON.toJSONString(flatMapList);
        System.out.println(jsonString2);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})).collect(toList());

    }

}
