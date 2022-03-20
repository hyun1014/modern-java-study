package com.modern.ch01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Apple {
    AppleColor color;
    int weight;

    public static boolean isGreen(Apple apple) {
        return apple.getColor().equals(AppleColor.GREEN);
    }
    public static boolean isHeavyThan100(Apple apple) {
        return apple.getWeight() > 100;
    }

    public static boolean isHeavyThanCondition(Apple apple, int weight) {
        return apple.getWeight() > weight;
    }


    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
