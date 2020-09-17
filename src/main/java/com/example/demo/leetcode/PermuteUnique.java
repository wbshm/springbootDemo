package com.example.demo.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
    List<List<Integer>> res;
    List<Integer> list;
    int[] nums;
    boolean[] check;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        Arrays.sort(nums);
        this.nums = nums;
        check = new boolean[nums.length];
        loop();
        return res;
    }

    public void loop() {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (check[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && check[i] == check[i - 1]) {
                continue;
            }
            check[i] = true;
            list.add(nums[i]);
            loop();
            list.remove(list.size() - 1);
            check[i] = false;
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> lists = permuteUnique(nums);
        System.out.println(lists);
    }
}
