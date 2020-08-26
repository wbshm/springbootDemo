package com.example.demo.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName RunningSum
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/26 16:46
 */
public class RunningSum {
    public int[] solution(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] res = new int[]{1, 3, 6, 10};
        assert Arrays.equals(solution(nums), res);
    }
}
