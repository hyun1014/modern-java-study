package com.modern;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File file = new File(".");
        File[] files = file.listFiles(File::isHidden);
        assert files != null;
        Arrays.stream(files).map(File::getName).forEach(System.out::println);
    }
}
