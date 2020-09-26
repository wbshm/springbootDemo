package com.example.demo.leetcode.arr;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Subsets
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/20 8:51
 */
public class Subsets {
    List<List<Integer>> res = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();

    public List<List<Integer>> subsets(int[] nums) {
        int pow = 1 << nums.length;
        for (int i = 0; i < nums.length; i++) {
            map.put(i, 1 << i);
        }
        while (pow > 0) {
            loop(nums, --pow);
        }
        return res;
    }

    public void loop(int[] nums, int loop) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length && loop > 0; i++) {
            if ((map.get(i) & loop) > 0) {
                list.add(nums[i]);
            }
        }
        res.add(list);
    }


    @Test
    public void test() {
        int[] input = new int[]{1, 2, 3};
        input = new int[]{0};
        List<List<Integer>> subsets = subsets(input);
        System.out.println(subsets);
    }
}
