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
    @SuppressWarnings("all")
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );
        //Find max value by comparator of Calories
        Comparator<Dish> comparator = Comparator.comparing(Dish::getCalories);
        Optional<Dish> maxCaloriesDish0 = menu.stream().max(comparator);
        Optional<Dish> maxCaloriesDish = menu.stream().collect(maxBy(comparator));
        System.out.println(maxCaloriesDish.get());

        //Sum all the calories
        Integer caloriesSumming0 = menu.stream().collect(summingInt(Dish::getCalories));
        int caloriesSumming1 = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(caloriesSumming0);
        System.out.println(caloriesSumming1);

        //Statistics
        IntSummaryStatistics dishSummaryStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(dishSummaryStatistics);

        String concatStr0 = menu.stream().map(Dish::getName).collect(joining());
        String concatStr1 = menu.stream().map(Dish::getName).collect(joining(", "));
        //Not support the format
        //String concatStr2 = menu.stream().collect(joining());
        System.out.println(concatStr0);
        System.out.println(concatStr1);
        //My collector -ToListCollector and it equals to the offical implementation
        //We build it without the static method.
        List<Dish> dishes0 = menu.stream().collect(new ToListCollector<>());
        List<Dish> dishes1 = menu.stream().collect(toList());
        System.out.println(dishes0);
        System.out.println(dishes1);
        //Function Support to define the Collector by ourselves
        List<Dish> dishes3 = menu.stream().collect(ArrayList::new, List::add, List::addAll);

    }
}
