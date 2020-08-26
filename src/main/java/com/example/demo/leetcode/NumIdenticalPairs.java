package com.example.demo.leetcode;

import org.junit.Test;

/**
 * @ClassName NumIdenticalPairs
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/26 16:53
 */
public class NumIdenticalPairs {
    public int solution(int[] nums) {
        int count;
        int res = 0;
        for (int j = 1; j < 100; j++) {
            count = 0;
            for (int num : nums) {
                if (j == num) {
                    count++;
                }
            }
            if (count > 1) {
                res += count * (count - 1);
            }
        }
        return res >> 1;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 1, 1, 3};
        System.out.println(solution(nums));
        assert 4 == solution(nums);
        nums = new int[]{1, 1, 1, 1, 3};
        System.out.println(solution(nums));
        assert 6 == solution(nums);
    }
}
