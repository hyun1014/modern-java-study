package com.modern.ch06;

import com.modern.CommonUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.modern.CommonUtil.*;


public class ReducingPractice {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(Currency.KO, 100),
                new Transaction(Currency.KO, 500),
                new Transaction(Currency.JP, 50),
                new Transaction(Currency.JP, 300),
                new Transaction(Currency.US, 80),
                new Transaction(Currency.US, 200)
        );

        long cnt1 = transactions.stream().collect(Collectors.counting());
        long cnt2 = transactions.stream().count();
        assert cnt1 != cnt2;

        transactions.stream().max(Comparator.comparingInt(Transaction::getCost)).ifPresent(CommonUtil::println);

        // num mapping
        int costSum = transactions.stream().mapToInt(Transaction::getCost).sum();
        println(costSum);

        // String join
        String joinedString = transactions.stream()
                                            .map(it -> "(" + it.getCurrency() + ", " + it.getCost() + ")")
                                            .collect(Collectors.joining(" / ", "[", "]"));
        println(joinedString);

        // grouping
        Map<Currency, List<Transaction>> currencyMap = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCurrency));
        currencyMap.get(Currency.JP).forEach(CommonUtil::println);

        Map<Currency, List<Transaction>> highCurrencyMap = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getCurrency,
                        Collectors.filtering(it -> it.getCost() >= 300, Collectors.toList())
                ));
        println(highCurrencyMap.get(Currency.US).stream().count());


    }
}
