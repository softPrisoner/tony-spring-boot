package com.tony.java8.interf.defaultfunc;

import java.util.Iterator;

/**
 * List
 * @author tony
 * @description List
 * @copyright rainbow
 * @date 2020/03/22
 */
public class List<T> implements Collection<T> {
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    /**
     * Implements it by user instead of default
     */
    @Override
    public void pickUp() {
    }
}
