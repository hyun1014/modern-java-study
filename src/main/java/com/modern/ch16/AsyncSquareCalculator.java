package com.modern.ch16;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class AsyncSquareCalculator {
    public static ExecutorService executor = Executors.newFixedThreadPool(10);

    public CompletableFuture<Integer> calculate(int value, long executionTime) {
        CompletableFuture<Integer> cf = new CompletableFuture<>();
        executor.submit(() -> {
            log.info("asyncCalculation start");
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(executionTime));
            } catch (InterruptedException e) {
                log.warn("Interrupted", e);
            }
            cf.complete(value * 100);
            log.info("asyncCalculation done");
        });
        return cf;
    }
}
