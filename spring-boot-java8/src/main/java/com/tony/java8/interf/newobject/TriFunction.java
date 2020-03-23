package com.tony.java8.interf.newobject;

/**
 * @author tony
 * @description TriFunction
 * @copyright rainbow
 * @date 2020/03/23
 */
@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
