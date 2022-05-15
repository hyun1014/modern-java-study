package com.modern.ch16;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class Shop {
    public static ExecutorService executor = Executors.newFixedThreadPool(10);

    public CompletableFuture<Integer> getPriceAsync(long executionTime) {
        CompletableFuture<Integer> cf = new CompletableFuture<>();
        executor.submit(() -> {
            log.info("getPrice start");
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(executionTime));
                int randomValue = Double.valueOf(Math.random() * 100).intValue();
                if (randomValue < 50) {
                    cf.complete(Double.valueOf(Math.random() * 100).intValue());
                    log.info("getPrice done");
                } else {
                    throw new IllegalArgumentException("price under 50");
                }
            } catch (Exception e) {
                log.warn("exception");
                cf.completeExceptionally(e);
            }
        });
        return cf;
    }
}
