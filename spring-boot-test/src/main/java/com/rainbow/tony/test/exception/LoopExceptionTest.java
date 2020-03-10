package com.rainbow.tony.test.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Loop exception edge test
 *
 * @author tony
 * @description LoopExceptionTest
 * @copyright rainbow
 * @date 2020/03/10
 */
public class LoopExceptionTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoopExceptionTest.class);
    private static final int TEST_CIRCLE_NUM = 10;

    /**
     * With inner try and catch
     */
    @SuppressWarnings("all")
    public static void innerExceptionTest() {
        int result = -1;
        //Don't stop the loop with exception
        for (int i = 0; i < TEST_CIRCLE_NUM; i++) {
            try {
                //An exception code
                result = 1 / 0;
            } catch (ArithmeticException e) {
                LOGGER.error("Divide the zero is wrong", result);
            }
        }
    }

    /**
     * With outer try and catch
     */
    @SuppressWarnings("all")
    public static void outerExceptionTest() {
        int result = -1;
        //Just executed once when the exception occur
        //And the compiler will give the check restriction
        try {
            for (int i = 0; i < TEST_CIRCLE_NUM; i++) {
                //An exception code
                result = i / 0;
            }
        } catch (ArithmeticException e) {
            LOGGER.error("Divide the zero is wrong", result);
        }

    }

    /**
     * Throw a manual exception test
     */
    @SuppressWarnings("all")
    public static void throwManualExceptionTest() {
        int result = -1;
        //
        try {
            for (int i = 0; i < TEST_CIRCLE_NUM; i++) {
                //An exception code
                throw new RuntimeException("Test exception.");
            }
        } catch (Exception e) {
            LOGGER.error("Divide the zero is wrong", result);
        }

    }

    /**
     * Throw a manual inner exception test
     */
    @SuppressWarnings("all")
    public static void innerThrowManualExceptionTest() {
        int result = -1;

        for (int i = 0; i < TEST_CIRCLE_NUM; i++) {
            try {
                //An exception code
                throw new RuntimeException("Test exception.");
            } catch (Exception e) {
                LOGGER.error("Divide the zero is wrong", result);
            }
        }


    }

    public static void main(String[] args) {
        innerExceptionTest();
        LOGGER.info("---------------------------------------------");
        outerExceptionTest();
        LOGGER.info("---------------------------------------------");
        throwManualExceptionTest();
        LOGGER.info("---------------------------------------------");
        innerThrowManualExceptionTest();
    }
}
