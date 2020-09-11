package com.example.demo.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-iii/
 *
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.8 MB, 在所有 Java 提交中击败了95.06%的用户
 *
 * @ClassName CombinationSum3
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/11 8:17
 */
public class CombinationSum3 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int n, int k) {
        bfs(1, n, k);
        return res;
    }

    public void bfs(int start, int k, int target) {
        if (k == list.size() + 1) {
            if (start <= target && target < 10) {
                list.add(target);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        for (int i = start; i < 10; i++) {
            list.add(i);
            bfs(i + 1, k, target - i);
            list.remove(list.size() - 1);
        }
    }

    @Test
    public void test() {
        List<List<Integer>> lists = combinationSum3(3, 8);
        System.out.println(lists);
    }

}
