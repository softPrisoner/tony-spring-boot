package com.rainbow.tony.design.pattern.factory;

/**
 * @author tony
 * @describe Square
 * @date 2019-11-11
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("画一个长方形~");
    }
}
