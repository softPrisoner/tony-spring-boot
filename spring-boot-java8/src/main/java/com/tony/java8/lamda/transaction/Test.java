package com.tony.java8.lamda.transaction;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * @author tony
 * @description Test
 * @copyright rainbow
 * @date 2020/03/25
 */
public class Test {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactionList = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        //2011 order asc List
        List<Transaction> orderAscList = transactionList.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());
        System.out.println(JSON.toJSONString(orderAscList));

        //Different city List
        List<String> distinctCityList = transactionList.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()  //or toSet
                .collect(toList());
        System.out.println(JSON.toJSONString(distinctCityList));

        //Cambridge trader List
        List<Trader> traderList = transactionList.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
        System.out.println(JSON.toJSONString(traderList));

        //Sort and concat with the trader's name
        String traderNameStr = transactionList.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (t1, t2) -> t1 + t2);
        System.out.println(traderNameStr);
        /*
        High speed and more effective with joining to concat with string.
         */
        String effectiveTraderNameStr = transactionList.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());
        System.out.println(effectiveTraderNameStr);

        //Any match of the trader living in Milan
        boolean match = transactionList.stream()
                .anyMatch(t -> "Milan".equals(t.getTrader().getCity()));
        System.out.println(match);

        //Print all transaction value of Cambridge.
        transactionList.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::print);

        //Max the value of transaction
        Optional<Integer> max = transactionList.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo);
        System.out.println(max);

        //Min the transaction
        Optional<Transaction> min = transactionList.stream()
                .min(comparing(Transaction::getValue));
        System.out.println(min);
    }
}
