package com.example.demo.leetcode;

import org.junit.Test;

import javax.xml.soap.SOAPEnvelope;

/**
 * @ClassName PivotIndex
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/5 10:22
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums.length <= 2) {
            return -1;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int left, right;
        left = 0;
        right = sum - nums[0];
        int loop = 0;
        while (loop < nums.length) {
            if (left == right) {
                return loop;
            }
            left += nums[loop];
            loop++;
            if (loop <= nums.length - 1) {
                right -= nums[loop];
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] num = new int[]{1, 2, 3};
        int i = pivotIndex(num);
        System.out.println(i);
        assert i == 4;

    }
}
