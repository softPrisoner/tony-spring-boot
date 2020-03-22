package com.tony.java8.lamda.vairlable;

/**
 * Test for thread
 *
 * @author tony
 * @description ThreadTest
 * @copyright rainbow
 * @date 2020/03/22
 */
public class ThreadVariableTest {
    /**
     * Belong to ThreadTest.class
     */
    public final int value = 4;

    private void doIt() {
        //outer local variable.
        int value = 6;
        //Ano-Class
        Runnable r = new Runnable() {
            //Inner variable.
            private final int value = 5;

            @Override
            public void run() {
                //local variable of the method.located in the stack space.
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }

    public static void main(String[] args) {
        ThreadVariableTest t = new ThreadVariableTest();
        t.doIt();
    }
}
