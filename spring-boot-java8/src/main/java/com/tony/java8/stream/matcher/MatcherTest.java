package com.tony.java8.stream.matcher;

import com.tony.java8.stream.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author tony
 * @description MatcherTest
 * @copyright rainbow
 * @date 2020/03/24
 */
public class MatcherTest {
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
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println();
        }
        //All match
        boolean allMatch = menu.stream().allMatch(item -> item.getCalories() < 801);
        System.out.println(allMatch);
        //None-Match
        boolean noneMatch = menu.stream().noneMatch(item -> item.getCalories() >= 1000);
        System.out.println(noneMatch);
        Optional<Dish> dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        //Menu
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));

        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);
        numberList.stream().map(x -> x * x)
                .filter(x -> x % 3 == 0)
                .findFirst();
        System.out.println(numberList);
    }


}
