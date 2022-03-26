package com.modern.ch03;

@FunctionalInterface
public interface CustomPredicate<T> {
    void customLet(T value);
}
