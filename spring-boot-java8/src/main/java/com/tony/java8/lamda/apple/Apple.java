package com.tony.java8.lamda.apple;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Apple for lambda expression
 *
 * @author tony
 * @description Apple
 * @copyright rainbow
 * @date 2020/03/21
 */
@Data
public class Apple {
    /**
     * Color of apple
     */
    private String color;
    /**
     * Weight of apple
     */
    private int weight;

    private static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    private static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    /**
     * Function for filter to describe the filter of origin function.
     *
     * @param inventory list collection
     * @param p         predicate
     * @return filtered list.
     */
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * ::方法引用
     */
    public static void main(String[] args) {
        List<Apple> appleList = Lists.newArrayList();
        //Reduce code.
        Apple.filterApples(appleList, Apple::isGreenApple);
        Apple.filterApples(appleList, Apple::isHeavyApple);
        //Easy for less use
        Apple.filterApples(appleList, (Apple a) -> "green".equals(a.getColor()));
        //Predicate predict,Action to parameter
        Apple.filterApples(appleList, (Apple a) -> a.getWeight() > 150);
        //Stream with lambda,defining the function by user.
        Stream<Apple> appleWithColorStream = appleList.stream().filter((Apple a) -> "green".equals(a.getColor()));
        Stream<Apple> appleWithWeightStream = appleList.stream().filter((Apple a) -> a.getWeight() > 150);
        //Filter
        Stream<Apple> appleWithColorStream2 = appleList.stream().filter((Apple::isGreenApple));
        //Collector.groupingBy()
        Map<String, List<Apple>> colorMapList = appleList.stream()
                .filter(Apple::isHeavyApple)
                .collect(Collectors.groupingBy(Apple::getColor));
    }

}
