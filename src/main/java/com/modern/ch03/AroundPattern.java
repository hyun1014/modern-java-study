package com.modern.ch03;

import java.io.BufferedReader;
import java.io.FileReader;

public class AroundPattern {
    public static void main(String[] args) {
//        readFile(args[0]);
        readFileWithProcessor(args[0], br -> System.out.println(br.readLine() + " / " + br.readLine()));
    }

    public static void readFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("from readFile: " + line);
            }
        } catch (Exception e) {
            System.out.println("exception");
        }
    }

    public static void readFileWithProcessor(String fileName, CustomBufferedReaderProcessor processor){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            processor.process(br);
        } catch (Exception e) {
            System.out.println("exception");
        }
    }
}
