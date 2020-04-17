package com.tony.java8.refactor;

/**
 * @author tony
 * @description Task
 * @copyright rainbow
 * @date 2020/04/17
 */
public class Test {
    public interface Task {
        void execute();
    }

    public static void doSomeThing(Runnable r) {
        r.run();
    }

    public static void doSomeThing(Task a) {
        a.execute();
    }

    public static void main(String[] args) {
        doSomeThing(new Task() {
            @Override
            public void execute() {
                System.out.println("Danger danger!!");
            }
        });
        //Ambiguous method call
//        doSomeThing(() -> System.out.println("Danger danger!!"));
    }
}
