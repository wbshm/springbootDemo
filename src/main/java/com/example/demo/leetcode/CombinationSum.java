package com.example.demo.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName CombinationSum
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/9 7:58
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        loop(res, new ArrayList<>(), 0, candidates, target);
        return res;
    }


    public void loop(List<List<Integer>> res, List<Integer> cur, int start, int[] candidates, int target) {
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            target -= candidate;
            if (target > 0) {
                cur.add(candidate);
                loop(res, cur, i, candidates, target);
                cur.remove(cur.size() - 1);
                target += candidate;
            } else if (0 == target) {
                cur.add(candidate);
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
                return;
            } else {
                break;
            }
        }
    }

    @Test
    public void test() {
        int[] c = new int[]{2, 3, 6, 7};
        List<List<Integer>> lists = combinationSum(c, 7);
        System.out.println(lists);
    }
}
