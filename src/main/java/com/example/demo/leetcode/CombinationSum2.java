package com.example.demo.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName CombinationSum2
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/10 7:38
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        HashMap<String, List<Integer>> map = new HashMap<>();
        loop(map, list, candidates, target, 0);
        return new ArrayList<>(map.values());
    }

    public void loop(HashMap<String, List<Integer>> res, List<Integer> list, int[] candidates, int target, int index) {
        int diff;
        StringBuilder key;
        for (int i = index; i < candidates.length; i++) {
            diff = target - candidates[i];
            if (diff == 0) {
                list.add(candidates[i]);
                key = new StringBuilder();
                for (int j : list) {
                    key.append(j);
                }
                res.put(key.toString(), new ArrayList<>(list));
                list.remove(list.size() - 1);
            } else if (diff > 0) {
                list.add(candidates[i]);
                loop(res, list, candidates, diff, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        int[] c = new int[]{10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = combinationSum2(c, 8);
        System.out.println(lists);
    }
}
