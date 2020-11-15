package com.example.demo.leetcode.arr;

import org.junit.Test;

public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int start = A[0];
        int end = A[A.length - 1];
        int i = 1;
        int j = A.length - 2;
        boolean modify = true;
        while (modify && i < A.length - 1 && j > 0) {
            modify = false;
            if (start < A[i]) {
                start = A[i];
                i++;
                modify = true;
            }
            if (end < A[j]) {
                end = A[j];
                j--;
                modify = true;
            }
        }
        return i == j + 2;
    }

    @Test
    public void test() {
        boolean b = validMountainArray(new int[]{1, 9, 8, 7, 6, 5, 4, 3});
        System.out.println(b);
    }
}
