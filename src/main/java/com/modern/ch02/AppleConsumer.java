package com.modern.ch02;

import com.modern.ch01.Apple;

public class AppleConsumer {
    public void printApple(Apple apple) {
        System.out.println("printing: " + apple.getColor() + " / " + apple.getWeight());
    }

    public static void staticPrintApple(Apple apple) {
        System.out.println("static printing: " + apple.getColor() + " - " + apple.getWeight());
    }
}
