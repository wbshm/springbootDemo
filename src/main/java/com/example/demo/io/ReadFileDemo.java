package com.example.demo.io;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @ClassName ReadFileDemo
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/9 16:21
 */
public class ReadFileDemo {
    public static void read() throws FileNotFoundException {
        String fileName = "D:\\project\\javaWorkSpace\\javaDemo\\src\\main\\java\\com\\example\\demo\\io\\read.txt";
        FileReader fileReader = new FileReader(fileName);
        FileInputStream inputStream = new FileInputStream(fileName);
        BufferedReader reader = new BufferedReader(fileReader);
        Stream<String> lines = reader.lines();
        lines.forEach((line) -> {
            String[] s = line.split(" ");
            System.out.println(Arrays.toString(s));
        });
    }

    public static void main(String[] args) throws FileNotFoundException {
        read();
    }
}
