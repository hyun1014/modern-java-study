package com.modern.ch03;

public class UsingCustomPredicate {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("abc");
        person.setAge(27);
        person.setCompany("foo");

        // not using lambda
        person.introduceSelf(new CustomPredicate<Person>() {
            @Override
            public void customLet(Person value) {
                System.out.println(person.getName() + " / " + person.getAge());
            }
        });

        // using lambda
        person.introduceSelf(p -> System.out.println("This is " + person.getName()));
    }
}
