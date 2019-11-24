package com.rainbow.tony.test.concurrent;

public class CurrentSingleton {
    private static CurrentSingleton singleton = null;

    private CurrentSingleton() {
    }

    public static synchronized CurrentSingleton get() {
        if (singleton == null) {
            synchronized (CurrentSingleton.class) {
                if (singleton == null) {
                    singleton = new CurrentSingleton();
                    return singleton;
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println(CurrentSingleton.get());
        System.out.println(CurrentSingleton.get());
    }
}
