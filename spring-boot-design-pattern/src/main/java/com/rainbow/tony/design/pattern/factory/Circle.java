package com.rainbow.tony.design.pattern.factory;

/**
 * @author tony
 * @describe Circle
 * @date 2019-11-11
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("画一个圆圈～");
    }
}
