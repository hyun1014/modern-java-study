package com.modern.ch05;

import com.modern.Common;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        // 5-2
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(3, 4);
        list1.stream().flatMap(num1 -> list2.stream().map(num2 -> num1 + " " + num2))
                      .forEach(System.out::println);
        Common.printLine();

        // 5-3
        list1.stream().flatMap(num1 -> list2.stream().filter(num2 -> (num1 + num2) % 3 == 0)
                                                     .map(num2 -> num1 + " " + num2))
                      .forEach(System.out::println);
        Common.printLine();

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milano");
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

        // 5-6-1
        transactionList.stream().filter(transaction -> transaction.getYear() == 2011)
                                .sorted(Comparator.comparingInt(Transaction::getValue))
                                .forEach(System.out::println);
        Common.printLine();

        // 5-6-2
        transactionList.stream().map(transaction -> transaction.getTrader().getCity())
                                .distinct()
                                .forEach(System.out::println);
        Common.printLine();

        // 5-6-3
        transactionList.stream().map(Transaction::getTrader)
                .filter(trader -> Objects.equals(trader.getCity(), "Cambridge")) // null-safe
                .distinct()
                .forEach(System.out::println);
        Common.printLine();

        // 5-6-4
        transactionList.stream().map(transaction -> transaction.getTrader().getName())
                .sorted(String::compareTo)
                .forEach(System.out::println);
        Common.printLine();

        // 5-6-5
        transactionList.stream().map(Transaction::getTrader)
                .filter(trader -> Objects.equals(trader.getCity(), "Milano"))
                .findAny()
                .ifPresent(System.out::println);
        Common.printLine();

        // 5-6-6
        transactionList.stream().filter(transaction -> Objects.equals(transaction.getTrader().getCity(), "Cambridge"))
                .forEach(System.out::println);
        Common.printLine();

        // 5-6-7
        transactionList.stream().map(Transaction::getValue).max(Integer::compare).ifPresent(System.out::println);
        Common.printLine();

        // 5-6-8
        transactionList.stream().map(Transaction::getValue).min(Integer::compare).ifPresent(System.out::println);
        Common.printLine();
    }
}
