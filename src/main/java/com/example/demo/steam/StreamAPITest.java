package com.example.demo.steam;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName StreamAPITest
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/22 20:54
 */
public class StreamAPITest {


    private static Integer apply(Integer t) {
        return t;
    }

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("nihao");
        list.add("nihao1");
        list.add("nihao2");
        list.add("nihao3");
        list.stream().forEach(System.out::println);

    }

    @Test
    public void test2() {
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
    }

    @Test
    public void test3() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(arr);
        stream.filter((v) -> v > 2).forEach(System.out::println);
    }

    @Test
    public void test4() {
        int[] arr = new int[]{1, 1, 1, 1, 2, 3, 4, 5, 5, 5, 5, 6};
        IntStream stream = Arrays.stream(arr);
//        stream.spliterator().trySplit();
//        Arrays.stream(arr).distinct().forEach(System.out::println);
//        Arrays.stream(arr).map((v) -> v + 1).distinct().forEach(System.out::println);
        Arrays.stream(arr).filter(v -> v > 3).distinct().map(v -> (char) v).forEach(System.out::println);
        Arrays.stream(arr).sorted().forEach(System.out::println);
    }
}
