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

    //

    /**
     * To support the stream auto
     * @return Dish name
     */
    @Override
    public String toString() {
        return this.name;
    }

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
