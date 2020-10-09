package com.example.demo.leetcode.num;

import org.junit.Test;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] sort = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sort);
        int i = 0;
        int j = sort.length - 1;
        int tmp;
        while (i < j) {
            tmp = sort[i] + sort[j];
            if (tmp == target) {
                break;
            } else if (tmp < target) {
                i++;
            } else {
                j--;
            }
        }
        boolean checkI = false;
        boolean checkJ = false;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == sort[i] && !checkI) {
                i = k;
                checkI = true;
            } else if (nums[k] == sort[j] && !checkJ) {
                j = k;
                checkJ = true;
            }
        }
        return new int[]{i, j};
    }

    @Test
    public void test() {
        int[] input = new int[]{-10, 7, 19, 15};
        int[] ints = twoSum(input, 9);
        System.out.println(Arrays.toString(ints));
    }
}
