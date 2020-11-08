package com.example.demo.leetcode.arr;

import org.junit.Test;

import java.util.Arrays;

public class UniqueOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        if (arr[arr.length - 1] != arr[arr.length - 2]) {
            return true;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                if (i == 0 || arr[i - 1] != arr[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        boolean b = uniqueOccurrences(new int[]{1, 2});
        System.out.println(b);
    }
}
