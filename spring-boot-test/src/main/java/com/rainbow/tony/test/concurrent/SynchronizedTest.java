package com.rainbow.tony.test.concurrent;

public class SynchronizedTest {
    private static int a = 5;

    public static void main(String[] args) {
        cc();
        System.out.println(a);
    }

    public static void cc() {
        synchronized (SynchronizedTest.class) {
            a++;
        }
    }
}
