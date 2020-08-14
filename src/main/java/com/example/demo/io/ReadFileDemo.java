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

    /**
     * try ... finally来编写上述代码会感觉比较复杂，
     * 更好的写法是利用Java 7引入的新的try(resource)的语法，只需要编写try语句，让编译器自动为我们关闭资源
     *
     * 实际上，编译器并不会特别地为InputStream加上自动关闭。
     * 编译器只看try(resource = ...)中的对象是否实现了java.lang.AutoCloseable接口，
     * 如果实现了，就自动加上finally语句并调用close()方法。InputStream和OutputStream都实现了这个接口，
     * 因此，都可以用在try(resource)中。
     * @throws FileNotFoundException
     */
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
