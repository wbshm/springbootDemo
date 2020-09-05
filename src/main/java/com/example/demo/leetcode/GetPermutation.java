package com.example.demo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/permutation-sequence/
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 *
 * @ClassName GetPermutation
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/5 9:12
 */
public class GetPermutation {
    public String getPermutation(int n, int k) {
        k--;
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(i + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n, num, loop; i > 0; i--) {
            num = factorial(i - 1);
            loop = k / num;
            k = k % num;
            sb.append(linkedList.remove(loop));
        }
        return sb.toString();
    }

    public int factorial(int number) {
        if (number <= 1) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }

    @Test
    public void test() {
        int n = 3, k = 5;
        String permutation = getPermutation(n, k);
        Assert.assertEquals("213", permutation);

    }
}

