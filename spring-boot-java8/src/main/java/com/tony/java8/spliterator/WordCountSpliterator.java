package com.tony.java8.spliterator;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Split iterator implementation for words by whitespace
 *
 * @author tony
 * @description MySpliterator
 * @copyright rainbow
 * @date 2020/04/17
 */
public class WordCountSpliterator implements Spliterator<Character> {
    private final String string;
    private int currentChar = 0;
    private final int MIN_UNIT_VAL = 10;
    private final int SPLIT_UNIT = 2;

    public WordCountSpliterator(String string) {
        this.string = string;
    }

    /**
     * Order access
     *
     * @param action Consumer
     * @return End?
     */
    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept(string.charAt(currentChar++));
        return currentChar < string.length();
    }

    @Override
    public void forEachRemaining(Consumer<? super Character> action) {

    }

    /**
     * 分割方法
     *
     * @return Spliterator
     */
    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        //No split
        if (currentSize < MIN_UNIT_VAL) {
            return null;
        }

        for (int splitPos = currentSize / SPLIT_UNIT + currentChar;
             splitPos < string.length(); splitPos++) {
            if (Character.isWhitespace(string.charAt(splitPos))) {
                Spliterator<Character> spliterator = new WordCountSpliterator(
                        string.substring(currentChar, splitPos));
                currentChar = splitPos;
                return spliterator;
            }
        }
        return null;
    }

    /**
     * estimateSize
     * This is not an exact value
     *
     * @return Size
     */
    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        //16+64+16384+256+1024
        //0x00004550
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
    /**
     * Get the exact size
     *
     * @return size
     */
    @Override
    public long getExactSizeIfKnown() {
        return 0;
    }


    @Override
    public boolean hasCharacteristics(int characteristics) {
        return false;
    }

    @Override
    public Comparator<? super Character> getComparator() {
        return null;
    }

}
