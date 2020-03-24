package com.tony.java8.stream.reduce;

import java.util.Arrays;
import java.util.List;

/**
 * @author tony
 * @description ReduceTest
 * @copyright rainbow
 * @date 2020/03/24
 */
public class ReduceTest {
    public static void main(String[] args) {
        int sum = 0;
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        for (int i : numbers) {
            sum += i;
        }
        System.out.println(sum);
        Integer reduceResult1 = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        Integer reduceResult2 = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(reduceResult2);
        numbers.stream().reduce(Integer::max);
    }
}
