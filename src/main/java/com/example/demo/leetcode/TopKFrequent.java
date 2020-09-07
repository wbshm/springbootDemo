package com.example.demo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @ClassName TopKFrequent
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/7 8:10
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (key, v) -> v = v == null ? 1 : v + 1);
        }
        LinkedList<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        int[] res = new int[k];
        while (k-- > 0) {
            Map.Entry<Integer, Integer> remove = list.pop();
            res[k] = remove.getKey();
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
        int k = 2;
        int[] ints = topKFrequent(nums, k);
        System.out.println(Arrays.toString(ints));
        Assert.assertArrayEquals(new int[]{1, 2}, ints);
    }
}
