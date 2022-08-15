package com.modern.ch05;

import com.modern.CommonUtil;
import com.modern.ch04.Dish;

import java.util.Arrays;
import java.util.List;

public class StreamSlicing {
    public static void main(String[] args) {
        List<Dish> dishList = Arrays.asList(
            new Dish("fruit", true, 120, Dish.Type.OTHER),
            new Dish("salad", true, 200, Dish.Type.OTHER),
            new Dish("tuna", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 500, Dish.Type.FISH),
            new Dish("lamb", false, 600, Dish.Type.MEAT),
            new Dish("pork", false, 800, Dish.Type.MEAT)
        );

        dishList.stream()
                .filter(Dish::isVegetarian)
                .forEach(System.out::println);
        CommonUtil.printLine();

        // takeWhile
        dishList.stream()
                .takeWhile(dish -> dish.getCalories() < 400)
                .forEach(System.out::println);
        CommonUtil.printLine();

        // dropWhile
        dishList.stream()
                .dropWhile(dish -> dish.getCalories() < 400)
                .forEach(System.out::println);
    }
}
