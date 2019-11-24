package com.rainbow.tony.design.pattern.factory;

/**
 * @author tony
 * @describe Rectangle
 * @date 2019-11-11
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("画一个正三角形~");
    }
}
