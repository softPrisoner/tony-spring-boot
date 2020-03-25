package com.tony.java8.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author tony
 * @description StreamTest
 * @copyright rainbow
 * @date 2020/03/24
 */
public class StreamTest {

    public static void main(String[] args) {
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> stream = title.stream();
        stream.forEach(System.out::println);
        stream.forEach(System.out::println);
        //String steam
        Stream<String> stringStream = Stream.of("Java 8", "Lambdas", "In", "Action");
        //Empty stream
        Stream<Object> emptyStream = Stream.empty();
        //Array to stream
        int[] numbers = {2, 3, 4, 5, 6};

        IntStream intStream = Arrays.stream(numbers);
        /*
        File Stream
         */
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(
                    line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Unique words count:" + uniqueWords);

        //Iterate stream
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        //Fibonacci implementation
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .map(t -> t[0])
                .forEach(System.out::println);

        //Generate Stream
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::print);

        IntStream.generate(() -> 2);
        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::print);
    }
}
