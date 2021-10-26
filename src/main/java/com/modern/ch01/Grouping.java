package com.modern.ch01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {
    public static void main(String[] args) {
        Map<Integer, List<String>> dict = new HashMap<>();
        List<String> wordList = new ArrayList<>();
        wordList.add("apple");
        wordList.add("alpha");
        wordList.add("banana");
        wordList.add("bravo");
        wordList.add("coke");
        wordList.add("charlie");

        for (String word : wordList) {
            if (word.length() > 5) {
                List<String> list = dict.get(5);
                if (list == null) {
                    list = new ArrayList<>();
                    dict.put(5, list);
                }
                list.add(word);
            }
        }
        List<String> list = dict.get(5);
        list.forEach(System.out::println);

    }
}
