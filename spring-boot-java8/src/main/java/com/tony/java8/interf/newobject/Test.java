package com.tony.java8.interf.newobject;

/**
 * @author tony
 * @description Test
 * @copyright rainbow
 * @date 2020/03/23
 */
public class Test {
    public static void main(String[] args) {
        TriFunction<Integer,Integer,Integer,Color> colorFactory=Color::new;
    }

}
