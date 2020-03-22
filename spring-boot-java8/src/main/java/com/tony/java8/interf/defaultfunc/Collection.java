package com.tony.java8.interf.defaultfunc;

import java.util.Iterator;

/**
 * List
 * @author tony
 * @description List
 * @copyright rainbow
 * @date 2020/03/22
 */
public interface Collection<E> extends Iterable<E> {

    @Override
    Iterator<E> iterator();
}
