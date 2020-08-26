package com.example.demo.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 * @ClassName ListTest
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/25 7:59
 */
public class ListTest {

    public static int Length = 5000000;
    public static int selectTimes = 10000;
    public static Random random = new Random(47);

    public static String[] getArray(int len) {
        String[] a = new String[len];
        for (int i = 0; i < len; i++) {
            a[i] = "test" + i;
        }
        return a;
    }

    @Test
    public void listTest() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getArray(Length)));

        int count = selectTimes;

        long start = System.nanoTime();
        while (count-- > 0) {
//            list.add(random.nextInt(Length), "test");
//            list.add(start + "test");
            list.add(0,"test");
        }
        long time = System.nanoTime() - start;
        double l = (double) time / 1_000_000_000;
        System.out.println("list  : " + l + "," + list.size());


        linkTest();
    }

    @Test
    public void linkTest() {
        LinkedList<String> list = new LinkedList<>(Arrays.asList(getArray(Length)));

        int count = selectTimes;
        long start = System.nanoTime();
        while (count-- > 0) {
//            list.add(random.nextInt(Length), "test");
//            list.add(start + "test");
            list.add(0,"test");
        }
        long time = System.nanoTime() - start;
        double l = (double) time / 1_000_000_000;
        System.out.println("linked: " + l + "," + list.size());

    }
}
