package com.tony.java8.refactor;

/**
 * @author tony
 * @description LambdaTest
 * @copyright rainbow
 * @date 2020/04/17
 */
public class LambdaTest {

    public void Before8Runnable() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };
    }

    public void java8Runnable() {
        //Anonymous Class
        Runnable r1 = () -> System.out.println("HELLO");
    }

    public static void main(String[] args) {
        //编译错误
//        int a = 10;
//        Runnable r1 = () -> {
//            int a = 2;
//            System.out.println(a);
//        }
        //正常编译
        int a = 10;
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                int a = 2;
                System.out.println("Hello");
            }
        };

    }

}
