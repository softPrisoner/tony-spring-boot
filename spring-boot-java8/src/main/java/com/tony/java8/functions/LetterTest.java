package com.tony.java8.functions;

import java.util.function.Function;

/**
 * @author tony
 * @description LetterTest
 * @copyright rainbow
 * @date 2020/03/23
 */
public class LetterTest {
    public static void main(String[] args) {
        //More flexible Demo1
        Function<String, String> addHeader = Letter::addHeader;
        addHeader.andThen(Letter::addFooter).andThen(Letter::checkSpelling);

        //Demo2 Changeable requirements
        addHeader
                .andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);
    }

}
