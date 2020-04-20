package com.tony.java8.spliterator;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Split iterator implementation for words by whitespace
 *
 * @author tony
 * @description MySpliterator
 * @copyright rainbow
 * @date 2020/04/17
 */
public class WordCountSpliteratorTest {
    public static void main(String[] args) {
        String testString = "i am tony.      Peter is my teacher   ";
        Spliterator<Character> spliterator = new WordCountSpliterator(testString);
        //Steam Support SP-Parallel
        Stream<Character> characterStream = StreamSupport.stream(spliterator, false);
        WordCounter wordCounter = new WordCounter(0, false);
        System.out.println(wordCounter.countWords(characterStream));
    }
}
