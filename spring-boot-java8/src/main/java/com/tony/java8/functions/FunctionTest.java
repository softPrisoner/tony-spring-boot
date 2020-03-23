package com.tony.java8.functions;

import java.util.function.Function;

/**
 * @author tony
 * @description FunctionTest
 * @copyright rainbow
 * @date 2020/03/23
 */
public class FunctionTest {
    public static void main(String[] args) {
        Function<String, Integer> stringToInteger = Integer::parseInt;

        //Function andThen
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> t = f.andThen(g);
        Integer res = t.apply(2);
        System.out.println(res);
        //Function Compose
        Function<Integer, Integer> t2 = f.compose(g);
        Integer res2 = t2.apply(2);
        System.out.println(res2);
    }

}
