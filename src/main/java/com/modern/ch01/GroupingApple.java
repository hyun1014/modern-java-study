package com.modern.ch01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingApple {
    public static void main(String[] args) {
        Apple apple1 = new Apple(AppleColor.RED, 100);
        Apple apple2 = new Apple(AppleColor.RED, 150);
        Apple apple3 = new Apple(AppleColor.RED, 200);
        Apple apple4 = new Apple(AppleColor.GREEN, 150);
        Apple apple5 = new Apple(AppleColor.GREEN, 200);
        Apple apple6 = new Apple(AppleColor.GREEN, 250);

        List<Apple> appleList = new ArrayList<>(List.of(apple1, apple2, apple3, apple4, apple5, apple6));
        Map<AppleColor, List<Apple>> appleMap = appleList.stream()
                                                         .filter(apple -> Apple.isHeavyThanCondition(apple, 150))
                                                         .collect(Collectors.groupingBy(Apple::getColor));

        appleMap.forEach((key, value) -> {
            System.out.println("Color: " + key);
            value.forEach(System.out::println);
        });
    }
}
