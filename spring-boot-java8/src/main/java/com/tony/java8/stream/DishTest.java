package com.tony.java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * @author tony
 * @description DishTest
 * @copyright rainbow
 * @date 2020/03/24
 */
public class DishTest {

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
        List<String> threeHighCaloricDishName = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(threeHighCaloricDishName);
        //Unbox operator
        IntStream intStream = menu.stream()
                .mapToInt(Dish::getCalories);
        //Transfer base stream to box operation

        Stream<Integer> boxedSteam = intStream.boxed();
        //How to decide if the stream is exist,instead of .
        OptionalInt maxIntValue = menu.stream().mapToInt(Dish::getCalories)
                .max();
        //if it's not exist,else the default value.
        int max = maxIntValue.orElse(1);
        System.out.println(max);

        //Condition for IntSteam [1,100]
        IntStream rangeIntStream = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        //range does't contain the value close.
        System.out.println(rangeIntStream.count());

        Map<Dish.Type, Set<String>> mapSet0 = menu.stream().collect(groupingBy(Dish::getType, mapping(dish -> {
            if (dish.getCalories() < 400) {
                return "DIET";
            } else if (dish.getCalories() < 700) {
                return "NORMAL";
            } else {
                return "FAT";
            }
        }, toSet())));
        System.out.println("mapSet0->" + mapSet0);

        Map<Dish.Type, HashSet<String>> mapSet = menu.stream().collect(groupingBy(Dish::getType, mapping(dish -> {
            if (dish.getCalories() < 400) {
                return "DEAT";
            } else if (dish.getCalories() < 700) {
                return "NORMAL";
            } else {
                return "FAT";
            }
        }, toCollection(HashSet::new))));

        System.out.println(mapSet);
        //PartitionBy which must return the boolean value.
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream().collect(partitioningBy(Dish::isVegetarian));
        List<Dish> vegetarianDishes = partitionedMenu.get(true);
        System.out.println(vegetarianDishes);

        //partitionBy then group by
        Map<Boolean, Map<Dish.Type, List<Dish>>> booleanMapMap = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
        System.out.println(booleanMapMap);

    }
}
