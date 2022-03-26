package com.modern.ch03;

import com.modern.ch01.Apple;
import com.modern.ch01.AppleColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppleSorting {
    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        BiFunction<AppleColor, Integer, Apple> appleBiFunction = Apple::new;
        appleList = Arrays.asList(appleBiFunction.apply(AppleColor.RED, 200),
                                  appleBiFunction.apply(AppleColor.GREEN, 100),
                                  appleBiFunction.apply(AppleColor.RED, 150),
                                  appleBiFunction.apply(AppleColor.GREEN, 200),
                                  appleBiFunction.apply(AppleColor.RED, 100),
                                  appleBiFunction.apply(AppleColor.GREEN, 150));

        // with comparator implement
        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });
        appleList.forEach(System.out::println);
        System.out.println("================");

        // using lambda
        appleList.sort((a1, a2) -> Integer.compare(a1.getWeight(), a2.getWeight()));
        appleList.forEach(System.out::println);
        System.out.println("================");

        // using method reference
        appleList.sort(Comparator.comparing(Apple::getWeight));
        appleList.forEach(System.out::println);
        System.out.println("================");

        // sorting by reversed order
        appleList.sort(Comparator.comparing(Apple::getWeight).reversed());
        appleList.forEach(System.out::println);
        System.out.println("================");

        // sorting with additional condition - AppleColor
        appleList.sort(Comparator.comparing(Apple::getWeight)
                                 .thenComparing(Apple::getColor));
        appleList.forEach(System.out::println);
        System.out.println("================");

        // filter by negate
        dummyFilter(appleList, apple -> apple.getColor().equals(AppleColor.RED)).forEach(System.out::println);
        System.out.println("================");

        // using mixed predicate
        appleList.stream()
                 .filter(useMixedPredicate(apple -> apple.getWeight() > 100, apple -> apple.getColor().equals(AppleColor.RED)))
                 .forEach(System.out::println);
        System.out.println("================");
    }

    public static List<Apple> dummyFilter(List<Apple> list, Predicate<Apple> predicate) {
        return list.stream().filter(predicate.negate()).collect(Collectors.toList());
    }

    public static Predicate<Apple> useMixedPredicate(Predicate<Apple> predicate1, Predicate<Apple> predicate2) {
        return predicate1.and(predicate2);
    }
}
