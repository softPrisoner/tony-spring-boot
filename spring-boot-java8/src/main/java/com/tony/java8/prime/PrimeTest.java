package com.tony.java8.prime;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * @author tony
 * @description PrimeTest
 * @copyright rainbow
 * @date 2020/03/27
 */
public class PrimeTest {
    public static boolean isPrime(int candidate) {
        return IntStream.rangeClosed(2, candidate)
                .noneMatch(i -> candidate % i == 0);
    }

    public boolean isPrime1(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    /**
     * Partition primes
     *
     * @param n N
     * @return Map
     */
    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(PrimeTest::isPrime));
    }
}
