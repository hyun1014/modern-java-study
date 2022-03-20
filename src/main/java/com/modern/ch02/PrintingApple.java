package com.modern.ch02;

import com.modern.ch01.Apple;
import com.modern.ch01.AppleColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class PrintingApple {
    public static void prettyPrintApple(List<Apple> list, AppleConsumer consumer) {
        list.forEach(consumer::printApple);
    }

    public static void main(String[] args) {
        Apple apple1 = new Apple(AppleColor.RED, 100);
        Apple apple2 = new Apple(AppleColor.GREEN, 150);
        Apple apple3 = new Apple(AppleColor.RED, 150);
        Apple apple4 = new Apple(AppleColor.GREEN, 200);

        // using lambda
        List<Apple> appleList = Arrays.asList(apple1, apple2, apple3, apple4);
        appleList.forEach(apple -> {
            System.out.println(apple.getColor() + " - " + apple.getWeight());
        });

        // sorting (lambda)
        appleList.sort((o1, o2) -> {
            if (o1.getWeight() == o2.getWeight()) {
                return Integer.compare(o1.getColor().ordinal(), o2.getColor().ordinal());
            } else {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });

        // using consumer
        prettyPrintApple(appleList, new AppleConsumer());
    }
}
