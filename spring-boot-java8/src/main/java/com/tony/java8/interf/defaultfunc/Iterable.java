package com.tony.java8.interf.defaultfunc;


import java.io.IOException;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author tony
 * @description Iterable
 * @copyright rainbow
 * @date 2020/03/22
 */
public interface Iterable<T> {
    Iterator<T> iterator();

    /**
     * Extend the interface function with the keyword default.
     *
     * @param action Consumer
     * @throws IOException IOE
     */
    default void forEach(Consumer<? super T> action) throws IOException {

    }

    /**
     * Define the function of pickUp for test.
     */
    default void pickUp() {

    }
}
