package com.example.demo.leetcode.arr;

import org.junit.Test;

import java.util.Arrays;
import java.util.TreeMap;

public class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        TreeMap<Double, int[]> map = new TreeMap<>(Double::compare);
        int tmp;
        int i = 0;
        for (int[] point : points) {
            tmp = point[0] * point[0] + point[1] * point[1];
            map.put(tmp + 0.000001 * (i++), point);
        }
        int[][] res = new int[k][2];
        i = 0;
        for (Double key : map.keySet()) {
            if (i < k) {
                res[i++] = map.get(key);
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[][] in = new int[][]{{0, 1}, {1, 0}};
        int[][] ints = kClosest(in, 2);
        System.out.println(Arrays.deepToString(ints));
    }
}
