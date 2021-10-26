package com.modern.ch01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Apple {
    String color;
    int weight;

    public static boolean isGreen(Apple apple) {
        return apple.getColor().toLowerCase().equals("green");
    }
    public static boolean isHeavy(Apple apple) {
        return apple.getWeight() > 100;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
