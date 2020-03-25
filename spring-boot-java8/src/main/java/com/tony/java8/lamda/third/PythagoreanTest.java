package com.tony.java8.lamda.third;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * IntStream
 * DoubleStream
 * LongStream
 *
 * @author tony
 * @description PythagoreanTest
 * @copyright rainbow
 * @date 2020/03/25
 */
public class PythagoreanTest {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        //Scope [1,100)
//        IntStream.range(1, 100).forEach(System.out::println);
        //Scope [1,100]
//        IntStream.rangeClosed(1, 100).forEach(System.out::println);

        /*
        Step1:
        filter(b->Math.sqrt(a*a+b*b)%1==0);

        Step2:
        stream
         .filter(b->Math.sqrt(a*a+b*b)%1==0)
         .map(b->new int[]{a,b,(int)Math.sqrt(a*a+b*b)})

        Step3:
      IntStream.rangeClosed(1, 100)
            .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed()
            .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)});

     Step4:
     IntStream.rangeClosed(1, 100)
            .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
           .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)});
         */

        //First,Create the Integer stream
        Stream<Integer> boxedIntegerStream0 = IntStream.rangeClosed(1, 100).boxed();
        Stream<Integer> boxedIntegerStream1 = IntStream.rangeClosed(1, 100).boxed();
        Stream<Integer> boxedIntegerStream2 = IntStream.rangeClosed(1, 100).boxed();
        Stream<int[]> stream0 = boxedIntegerStream0
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        //Boxed
                        .boxed()
                        .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        stream0.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
        System.out.println("----------------------------------------------------------------------------");
        Stream<int[]> stream = boxedIntegerStream1
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        //Boxed at the different time
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));

        stream.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        System.out.println("----------------------------------------------------------------------------");
        //Double type
        Stream<double[]> stream2 = boxedIntegerStream2
                .flatMap(
                        a -> IntStream.rangeClosed(a, 100).mapToObj(
                                b -> new double[]{a, b, (double) Math.sqrt(a * a + b * b)})
                                .filter(t -> t[2] % 1 == 0)
                );
        stream2.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }
}
