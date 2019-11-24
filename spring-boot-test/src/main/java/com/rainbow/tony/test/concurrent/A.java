package com.rainbow.tony.test.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class A {

    public static void main(String[] args) {
        CurrentMap a = new CurrentMap() {
        };
        Map m = new Map() {
            @Override
            public void sayHello() {
                System.out.println("map:say hello");

            }
        };
        CurrentMap c = new CurrentMap() {
            public void sayHello() {
                System.out.println("myname---");
            }
        };
        a.sayHello();
        m.sayHello();
        c.sayHello();
        Thread a1 = new Thread(() -> {
            System.out.println("abc");
        });
        a1.start();
        ExecutorService pool = Executors.newFixedThreadPool(5);
        Future<Integer> submit2 = pool.submit(() -> (1));
        try {
            System.out.println(submit2.get());
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        // filter1(languages,(str)->true);
        // filter1(languages,(str)->false);
        Predicate<String> a11 = (n) -> n.length() == 4;
        Predicate<String> b = (n) -> n.startsWith("J");
        Predicate<String> and = a11.and(b);
        filter(languages, a11.or(b));
    }

    public static void filter(List<String> names, Predicate<String> condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }

    public static void filter1(List<String> names, Predicate<String> condition) {
        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
            System.out.println(name + " ");
        });
        names.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String t) {
                System.out.println(t);
                return false;
            }
        }).forEach(new Consumer<String>() {

            @Override
            public void accept(String t) {
                System.out.println(t);

            }
        });
    }

}
