package com.modern.ch16;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.*;

@Slf4j
public class Main {
    public static CompletableFuture<String> makeChainedCf(long executionTime, CompletableFuture<String> cf) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("cf start");
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(executionTime));
            } catch (InterruptedException e) {
                log.warn("inturrupted!");
            }
            log.info("cf done");
            return Thread.currentThread().getName();
        });
    }

    public static void main(String[] args) throws Exception{
        // Future
//        SquareCalculator calculator = new SquareCalculator();
//
//        Future<Integer> future = calculator.calculate(10, 3L);
//        for (int i = 0; i < 5; i++) {
//            log.info("sleep in main thread -> " + i);
//            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
//        }
//        try {
//            log.info(future.get(1, TimeUnit.SECONDS).toString());
//        } catch (TimeoutException e) {
//            // Timeout이 발생해도 executor에서 잡고 있는 submit은 멈추지 않는다.
//            log.error("timeout exception", e);
//            // interrupt로 멈추게 가능. executor가 thread pool 사용할 경우엔 안멈추네...
//            future.cancel(true);
//        }

        // Completable
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            log.info("cf - string");
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(1L));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("done");
            return "Hello";
        });

        CompletableFuture<String> cf3 = new CompletableFuture<>();
        log.info(cf3.isDone() ? "cf3 completed" : "cf3 not completed");

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            log.info("cf - string");
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(1L));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("done");
            cf3.complete("cf2 is completed!");
            return "Hello";
        });

        log.info(cf1.get());
        log.info(cf2.get());

        log.info(cf3.isDone() ? "cf3 completed" : "cf3 not completed");
        log.info(cf3.get());

        CompletableFuture<String> cf4 = new CompletableFuture<>();
        cf4.completeExceptionally(new CancellationException("cancelled"));

        try {
            log.info(cf4.get());
        } catch (CancellationException e) {
            log.error(e.getMessage());
        }

        CompletableFuture<String> cf5 = new CompletableFuture<>();

//        Shop shop1 = new Shop();
//        CompletableFuture<Integer> cf = shop1.getPriceAsync(6L);
//        for (int i = 0; i < 5; i++) {
//            Thread.sleep(1000);
//            log.info("sleep... " + i);
//        }
//        log.info("price1 = " + cf.get(30, TimeUnit.SECONDS));
//
//        Shop.executor.shutdown();
    }
}