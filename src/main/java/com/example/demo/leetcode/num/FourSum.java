package com.example.demo.leetcode.num;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    int cur = nums[i] + nums[j] + nums[k];
                    if (cur + nums[nums.length - 1] < target || cur + nums[k + 1] > target) {
                        continue;
                    }
                    for (int l = k + 1; l < nums.length; l++) {
                        if (l > k + 1 && nums[l] == nums[l - 1]) {
                            continue;
                        }
                        if (cur + nums[l] == target) {
                            ArrayList<Integer> objects = new ArrayList<>(4);
                            objects.add(nums[i]);
                            objects.add(nums[j]);
                            objects.add(nums[k]);
                            objects.add(nums[l]);
                            res.add(objects);
                        }
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] input = new int[]{-2, -1, -1, 1, 1, 2, 2};
        List<List<Integer>> lists = fourSum(input, 0);
        System.out.println(lists);

    }
}
