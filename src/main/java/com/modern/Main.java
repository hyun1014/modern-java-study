package com.modern;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File[] hiddenFiles = new File(".").listFiles(file -> file.isHidden());
        Arrays.stream(hiddenFiles).forEach(System.out::println);
    }
}
