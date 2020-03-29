package com.tony.java8.recursive;

/**
 * @author tony
 * @description ForkJoinSumTaskTest
 * @copyright rainbow
 * @date 2020/03/29
 */
public class ForkJoinSumTaskTest {

    public static void main(String[] args) {
        long sumResult = ForkJoinSumCalculator.forkJoinSum(100);
        System.out.println(sumResult);
    }
}
