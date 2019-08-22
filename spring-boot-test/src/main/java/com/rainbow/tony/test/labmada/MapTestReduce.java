package com.rainbow.tony.test.labmada;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class MapTestReduce {
    static List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400);

    public static void main(String[] args) {
//		Reduce();
//		filter();
//		copy();
//		removeRepeat();
        getMaxAvlMin();
    }

    public static void Map() {
//		for(Integer cost:costBeforeTax) {
//		double price=cost+.12*cost;
//		System.out.println(price);
//	}
        // jdk1.8
        costBeforeTax.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);
    }

    public static void Reduce() {
        double total = 0;
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            total += price;
        }
        System.out.println(total);
        double bill1 = costBeforeTax.stream().map(cost -> cost + .12 * cost).reduce(new BinaryOperator<Double>() {

            @Override
            public Double apply(Double sum, Double cost) {

                return sum + cost;
            }
        }).get();
        double bill = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("SUM=" + bill);
    }

    public static void change() {
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K", "Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(G7Countries);
    }

    public static void removeRepeat() {
        List<Integer> numerSet = Arrays.asList(1, 1, 8, 3, 2, 3, 4);
        List<Integer> collect = numerSet.parallelStream().distinct().sorted().collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
    }

    public static void copy() {
        List<Integer> numerSet = Arrays.asList(1, 1, 8, 3, 2, 3, 4);
        List<Integer> coll = numerSet.stream().distinct().map(x -> x * x).sorted().collect(Collectors.toList());
        coll.stream().forEach(System.out::println);
    }

    public static void filter() {
        costBeforeTax.stream().filter(x -> true).forEach(System.out::println);
        List<Integer> collect = costBeforeTax.stream().filter((x) -> x > 200).collect(Collectors.toList());
        collect.stream().filter(x -> true).forEach(System.out::println);
    }

    public static void getMaxAvlMin() {
        IntSummaryStatistics stats = costBeforeTax.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("getMax" + stats.getMax());
        System.out.println("getAverage:" + stats.getAverage());
        System.out.println("getMin" + stats.getMin());
        System.out.println("getCount" + stats.getCount());
        System.out.println("getSum" + stats.getSum());
    }

}
