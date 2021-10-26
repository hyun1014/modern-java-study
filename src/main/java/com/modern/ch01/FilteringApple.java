package com.modern.ch01;

import java.util.ArrayList;
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
        Apple apple1 = new Apple("Green", 150);
        Apple apple2 = new Apple("Red", 150);
        Apple apple3 = new Apple("Green", 50);

        List<Apple> appleList = new ArrayList<>();
        appleList.add(apple1);
        appleList.add(apple2);
        appleList.add(apple3);

        System.out.println("Weight filtered");
        List<Apple> weightFilteredList = getFilteredApples(appleList, Apple::isHeavy);
        weightFilteredList.forEach(System.out::println);

        System.out.println("Color filtered");
        List<Apple> colorFilteredList = getFilteredApples(appleList, Apple::isGreen);
        colorFilteredList.forEach(System.out::println);

        System.out.println("Weight filtered 2");
        getFilteredApples(appleList, apple -> apple.getWeight() < 200).forEach(System.out::println);
    }
}
