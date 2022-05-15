package com.modern.ch16;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SquareCalculator {
    public ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<Integer> calculate(Integer value, Long executionMillSecond) {
        return executor.submit(() -> {
            log.info("start calculation.");
            Thread.sleep(TimeUnit.SECONDS.toMillis(executionMillSecond));
            log.info("finish calculation.");
            return Double.valueOf(Math.pow(value, value)).intValue();
        });
    }
}
