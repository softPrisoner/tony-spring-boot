package com.rainbow.tony.test.design.builder;

public class Builder {
    private static int a;

    public void inner() {
        class A {
        }
    }

    public static void staticInner() {
        final int a = 0;

        class B {
            public int abc() {
                return a;
            }
        }
        B b = new B();
        b.abc();
    }

    class a {
    }

    public static void main(String[] args) {
        a a = new Builder().new a();
    }
}
