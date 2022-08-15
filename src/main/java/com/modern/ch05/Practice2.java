package com.modern.ch05;

import com.modern.CommonUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static com.modern.CommonUtil.*;

public class Practice2 {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milano");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 5-6-1
        transactions.stream()
                .filter(it -> it.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(CommonUtil::println);

        printLine();

        // 5-6-2
        transactions.stream()
                .map(it -> it.getTrader().getCity())
                .distinct()
                .forEach(CommonUtil::println);

        printLine();

        // 5-6-3
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(it -> it.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(CommonUtil::println);

        printLine();

        // 5-6-4
        transactions.stream()
                .map(it -> it.getTrader().getName())
                .distinct()
                .sorted(String::compareTo)
                .forEach(CommonUtil::println);

        printLine();

        // 5-6-5
        boolean isExists = transactions.stream()
                .anyMatch(it -> it.getTrader().getCity().equals("Milano"));
        println(isExists);

        printLine();

        // 5-6-6
        transactions.stream()
                .filter(it -> it.getTrader().getCity().equals("Cambridge"))
                .forEach(CommonUtil::println);

        printLine();

        // 5-6-7
        Transaction maxTransaction = transactions.stream()
                .max(Comparator.comparingInt(Transaction::getValue))
                .get();
        println(maxTransaction);

        printLine();

        // 5-6-8
        Transaction minTransaction = transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue))
                .get();
        println(minTransaction);

        printLine();
    }
}
