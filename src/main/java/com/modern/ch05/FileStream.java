package com.modern.ch05;

import com.modern.CommonUtil;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileStream {
    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get("words.txt"))) {
             lines.distinct().forEach(CommonUtil::println);
        } catch (Exception e) {

        }
    }
}
