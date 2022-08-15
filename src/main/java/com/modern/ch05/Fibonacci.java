package com.modern.ch05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());

        Stream.iterate(new int[] {0, 1}, it -> new int[] {it[1], it[0] + it[1]})
                .limit(num)
                .skip(num - 1)
                .findFirst()
                .ifPresent(it -> System.out.println(it[1]));
    }
}
