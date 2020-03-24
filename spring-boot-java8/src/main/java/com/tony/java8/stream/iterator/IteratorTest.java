package com.tony.java8.stream.iterator;

import com.tony.java8.stream.Dish;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tony
 * @description IteratorTest
 * @copyright rainbow
 * @date 2020/03/24
 */
@Slf4j
public class IteratorTest {
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
        //Outer Iterator
        List<Dish> vegetarianDishes = new ArrayList<>();
        for (Dish d : menu) {
            if (d.isVegetarian()) {
                vegetarianDishes.add(d);
            }
        }
        //Inner Iterator
        vegetarianDishes = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());

    }

}
