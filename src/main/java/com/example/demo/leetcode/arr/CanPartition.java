package com.example.demo.leetcode.arr;

import org.junit.Test;

import java.util.Arrays;

public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        Arrays.sort(nums);
        boolean[] check = new boolean[nums.length];
        check[check.length - 1] = true;
        target -= nums[nums.length - 1];
        return target == 0 || loop(nums, check, target);
    }

    public boolean loop(int[] nums, boolean[] check, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (check[i]) {
                continue;
            }
            target -= nums[i];
            if (target == 0) {
                return true;
            }
            if (target > 0) {
                check[i] = true;
                boolean loop = loop(nums, check, target);
                if (loop) {
                    return true;
                }
                check[i] = false;
                target += nums[i];
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[] in = new int[]{28, 63, 95, 30, 39, 16, 36, 44, 37, 100, 61, 73, 32, 71, 100, 2, 37, 60, 23, 71, 53, 70, 69, 82, 97, 43, 16, 33, 29, 5, 97, 32, 29, 78, 93, 59, 37, 88, 89, 79, 75, 9, 74, 32, 81, 12, 34, 13, 16, 15, 16, 40, 90, 70, 17, 78, 54, 81, 18, 92, 75, 74, 59, 18, 66, 62, 55, 19, 2, 67, 30, 25, 64, 84, 25, 76, 98, 59, 74, 87, 5, 93, 97, 68, 20, 58, 55, 73, 74, 97, 49, 71, 42, 26, 8, 87, 99, 1, 16, 79};
        boolean b = canPartition(in);
        System.out.println(b);
    }
}
