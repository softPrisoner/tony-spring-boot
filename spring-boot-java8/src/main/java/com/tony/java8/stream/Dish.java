package com.tony.java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author tony
 * @description Dish
 * @copyright rainbow
 * @date 2020/03/24
 */
@Data
@AllArgsConstructor
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public enum Type {
        /**
         * MEAT
         */
        MEAT,
        /**
         * FISH
         */
        FISH,
        /**
         * OTHER
         */
        OTHER
    }

}
