package com.modern;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int[] dx = new int[] {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = new int[] {-1, -2, -2, -1, 1, 2, 2, 1};
    static boolean[][] visited = new boolean[300][300];
    static Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
//        System.out.println(UUID.randomUUID().toString());
//        System.out.println(UUID.randomUUID().toString());
//
//        String fileName = "123.jpg?width=100&height=100";
//        Arrays.stream(fileName.split("\\?.*=")).forEach(System.out::println);

        Double d = null;

        try {
            boolean flag = BigDecimal.valueOf(d).compareTo(BigDecimal.valueOf(0.3)) > 0;
            System.out.println(flag);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
