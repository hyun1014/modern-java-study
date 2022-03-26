package com.modern.ch03;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;
    private int age;
    private String company;

    public void introduceSelf(CustomPredicate<Person> customPredicate) {
        customPredicate.customLet(this);
    }
}
