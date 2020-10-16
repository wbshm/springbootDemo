package com.example.demo.leetcode.arr;

import org.junit.Test;

import java.util.Arrays;

public class SortedSquares {
    public int[] sortedSquares(int[] A) {
        int[] B = new int[A.length];
        int i = 0, j = B.length - 1;
        int index = B.length;
        for (int k = 0; k < A.length; k++) {
            A[k] *= A[k];
        }
        while (index > 0) {
            index--;
            if (A[i] < A[j]) {
                B[index] = A[j--];
            } else {
                B[index] = A[i++];
            }
        }
        return B;
    }

    @Test
    public void test() {
        int[] in = new int[]{-7, -3, 2, 3, 11};
        int[] ints = sortedSquares(in);
        System.out.println(Arrays.toString(ints));
    }
}
