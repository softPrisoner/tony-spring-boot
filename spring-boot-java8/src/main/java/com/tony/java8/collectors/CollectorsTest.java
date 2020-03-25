package com.tony.java8.collectors;

import com.tony.java8.stream.Dish;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * @author tony
 * @description CollectorTest
 * @copyright rainbow
 * @date 2020/03/25
 */

public class CollectorsTest {

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        Comparator<Dish> comparator = Comparator.comparing(Dish::getCalories);
        menu.stream().max(comparator);
        Optional<Dish> maxCaloriesDish = menu.stream().collect(maxBy(comparator));
        System.out.println(maxCaloriesDish.get());
        //summing
        Integer summingInt = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(summingInt);
        //summing
        System.out.println(menu.stream().mapToInt(Dish::getCalories).sum());
        //Statistics
        IntSummaryStatistics intSummaryStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(intSummaryStatistics);

        String concatStr = menu.stream().map(Dish::getName).collect(joining());
        //this is not support
//        String concatStr2 = menu.stream().collect(joining());
        System.out.println(concatStr);
        String concatStr1 = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(concatStr1);


    }
}
