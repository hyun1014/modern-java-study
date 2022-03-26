package com.modern.ch03;

import com.modern.ch01.Apple;
import com.modern.ch01.AppleColor;

import java.util.function.*;

public class InterfaceTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("abc");
        person.setAge(27);
        person.setCompany("foo");

        testPredicate(person, new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() < 20;
            }
        });
        // using lambda
        testPredicate(person, p -> p.getAge() > 20);

        testConsumer(person, new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println("Age of " + person.getName() + " is " + person.getAge());
            }
        });
        // using lambda
        testConsumer(person, p -> System.out.println("Company of " + person.getName() + " is " + person.getCompany()));

        Person personAfterFunction = testFunction(person, p -> {
            p.setCompany("google");
            return p;
        });
        System.out.println("company after function: " + personAfterFunction.getCompany());

        testSupplier(person, () -> "from supplier");

        Integer modifiedAge = testUnaryOperator(person.getAge(), n -> n * 2, n -> n + 2);
        System.out.println(modifiedAge);

        class Foo {
            int num;
            Foo(int num) {this.num = num;}
        }

        Function<Integer, Foo> f1 = Foo::new;
        BiFunction<AppleColor, Integer, Apple> b1 = Apple::new;
    }

    static <T> void testPredicate(T target, Predicate<T> predicate) {
        System.out.println("from testPredicate");
        if (predicate.test(target)) {
            System.out.println("predicate pass");
        } else {
            System.out.println("predicate fail");
        }
    }

    static <T> void testConsumer(T target, Consumer<T> consumer) {
        System.out.println("from testConsumer");
        consumer.accept(target);
    }

    static <T, R> R testFunction(T target, Function<T, R> function) {
        System.out.println("from testFunction");
        return function.apply(target);
    }

    static <T> void testSupplier(Person target, Supplier<T> supplier) {
        System.out.println("from testSupplier");
        T value = supplier.get();
        System.out.println("T is " + value.getClass().getName());
        target.setName(target.getName() + " - " + value);
        System.out.println("name after supplier: " + target.getName());
    }

    static <T> T testUnaryOperator(T target, UnaryOperator<T> unaryOperatorBefore, UnaryOperator<T> unaryOperatorAfter) {
        System.out.println("from testUnaryOperator");
        T modifiedTarget = unaryOperatorBefore.andThen(unaryOperatorAfter).apply(target);
        return modifiedTarget;
    }
}
