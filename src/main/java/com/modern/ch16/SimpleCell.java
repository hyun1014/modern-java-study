package com.modern.ch16;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow.*;

@Slf4j
public class SimpleCell implements Publisher<Integer>, Subscriber<Integer> {
    private int value = 0;
    private String name;
    private List<Subscriber> subscribers = new ArrayList<>();
    public SimpleCell(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        // TODO
    }

    @SuppressWarnings("unchecked")
    public void notifyAllSubscribers() {
        subscribers.forEach(it -> it.onNext(this.value));
    }

    @Override
    public void onNext(Integer item) {
        this.value = item;
        log.info(this.name + " value assigned -> " + this.value);
        log.info(Thread.currentThread().getName());
        notifyAllSubscribers();

    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete");
    }
}
