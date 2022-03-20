package com.modern.ch01;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringApple {
    public static List<Apple> filterApple(List<Apple> list, Predicate<Apple> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Apple apple1 = new Apple(AppleColor.RED, 100);
        Apple apple2 = new Apple(AppleColor.GREEN, 200);
        Apple apple3 = new Apple(AppleColor.GREEN, 150);
        List<Apple> appleList = new ArrayList<>(List.of(apple1, apple2, apple3));

        // classic
        Collections.sort(appleList, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });
        appleList.forEach(System.out::println);
        System.out.println();

        // using lambda
        appleList.sort((a1, a2) -> Integer.compare(a2.getWeight(), a1.getWeight()));
        appleList.forEach(System.out::println);
        System.out.println();

        // using functional
        appleList.sort(Comparator.comparingInt(Apple::getWeight));
        appleList.forEach(System.out::println);
        System.out.println();

        // filtering by weight 100
        List<Apple> filteredList = filterApple(appleList, Apple::isHeavyThan100);
        filteredList.forEach(System.out::println);
        System.out.println();

        List<Apple> filteredList2 = appleList.stream().filter(apple -> Apple.isHeavyThanCondition(apple, 150)).collect(Collectors.toList());
        filteredList2.forEach(System.out::println);
        System.out.println();
    }
}
