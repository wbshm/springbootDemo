package com.example.demo.leetcode.arr;

import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName MaxProfit
 * @Description TODO
 * @Author wangrq
 * @Date 2020/11/8 17:12
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int sum = 0;
        int start = -1;
        for (int i = 1; i < prices.length; i++) {
            if (start == -1) {
                if (prices[i] > prices[i - 1]) {
                    start = prices[i - 1];
                }
            } else {
                if (prices[i] < prices[i - 1]) {
                    sum += prices[i - 1] - start;
                    start = -1;
                }
            }
        }
        if (start != -1) {
            sum += prices[prices.length - 1] - start;
        }
        return sum;
    }

    @Test
    public void test() {
        int[] input = new int[]{1,2,3,4,5};
        int i = maxProfit(input);
        Assert.assertEquals(7, i);
    }
}
