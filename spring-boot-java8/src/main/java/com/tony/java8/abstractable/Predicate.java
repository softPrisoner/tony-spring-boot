package com.tony.java8.abstractable;

import java.util.ArrayList;
import java.util.List;

/**
 * Mock for Predicate<T></>
 *
 * @author tony
 * @description Predicate
 * @copyright rainbow
 * @date 2020/03/22 上午 8:53
 */
public interface Predicate<T> {
    /**
     * Mock for test
     *
     * @param t T
     * @return boolean
     */
    boolean test(T t);

    /**
     * Mock Collection filter.
     *
     * @param list List collection
     * @param p    Predicate
     * @param <T>  Param type
     * @return Filter List
     */
    @SuppressWarnings("unused")
    static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}


