package com.modern.ch03;

import java.io.BufferedReader;

@FunctionalInterface
public interface CustomBufferedReaderProcessor {
    void process(BufferedReader br) throws Exception;
}
