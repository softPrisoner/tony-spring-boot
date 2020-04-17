package com.tony.java8.spliterator;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Word counter
 *
 * @author tony
 * @description WordCount
 * @copyright rainbow
 * @date 2020/04/17
 */
class WordCounter {
    private final int counter;

    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        //0
        this.counter = counter;
        //false
        this.lastSpace = lastSpace;
    }

    public WordCounter accumulate(Character c) {
        //Is whitespace
        if (Character.isWhitespace(c)) {
            return lastSpace ? this : new WordCounter(counter, true);
        } else {
            return lastSpace ? new WordCounter(counter + 1, false) : this;
        }
    }

    /**
     * Combine the subtask
     *
     * @param wordCounter WordCounter
     * @return WordCounter
     */
    public WordCounter combine(WordCounter wordCounter) {
        return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
    }

    public int getCounter() {
        return this.counter;
    }

    public int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate, WordCounter::combine);

        return wordCounter.getCounter();
    }

    public static void main(String[] args) {
        //Init test string
        String testString = "i am tony.      Peter is my teacher   ";
        WordCounter wordCounter = new WordCounter(0, false);
        //Sequence stream
        Stream<Character> characterStream = IntStream.range(0, testString.length())
                .mapToObj(testString::charAt);
        //Parallel stream
        Stream<Character> characterStream2 = IntStream.range(0, testString.length())
                .mapToObj(testString::charAt);
        //Count
        System.out.println(wordCounter.countWords(characterStream));
        System.out.println(wordCounter.countWords(characterStream2.parallel()));
    }

}
