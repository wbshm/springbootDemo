package com.example.demo.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName FindUnsortedSubarray
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/26 17:25
 */
public class FindUnsortedSubarray {

    public int solution(int[] nums) {
        int[] row = nums.clone();
        Arrays.sort(row);
        for (int i = 0; i < row.length; i++) {
            if (row[i] != nums[i]) {
                for (int j = row.length - 1; j > i; j--) {
                    if (row[j] != nums[j]) {
                        return j - i + 1;
                    }
                }
                break;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        System.out.println(solution(nums));
        assert 5 == solution(nums);
    }
}
