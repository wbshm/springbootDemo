package com.example.demo.leetcode.arr;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int value : nums1) {
            set.add(value);
        }
        for (int value : nums2) {
            if (set.contains(value)) {
                res.add(value);
            }
        }
        int[] rtn = new int[res.size()];
        int i = 0;
        for (Integer r : res) {
            rtn[i++] = r;
        }
        return rtn;
    }

    @Test
    public void test() {

    }
}
