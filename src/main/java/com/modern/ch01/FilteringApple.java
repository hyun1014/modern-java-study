package com.modern.ch01;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApple {
    static List<Apple> getFilteredApples(List<Apple> list, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();

        // loop
        for (Apple apple : list) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        // stream
        list.stream().filter(p).forEach(result::add);

        return result;
    }
    public static void main(String[] args) {
        Apple apple1 = new Apple(AppleColor.RED, 10);
        Apple apple2 = new Apple(AppleColor.GREEN, 20);
        Apple apple3 = new Apple(AppleColor.GREEN, 15);
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


    }
}
