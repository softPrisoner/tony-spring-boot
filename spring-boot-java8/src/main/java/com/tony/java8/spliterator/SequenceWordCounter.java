package com.tony.java8.spliterator;

/**
 * @author tony
 * @description SequenceWordCounter
 * @copyright rainbow
 * @date 2020/04/17
 */
public class SequenceWordCounter {

    /**
     * Count words
     *
     * @param s origin words
     * @return Counters
     */
    public int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            //Ignore the white space
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) {
                    counter++;
                }
                lastSpace = false;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        String testString = "i am tony    .Peter is my teacher   ";
        SequenceWordCounter spliterator = new SequenceWordCounter();
        System.out.println(spliterator.countWordsIteratively(testString));
    }
}
