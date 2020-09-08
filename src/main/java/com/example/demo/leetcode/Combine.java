package com.example.demo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Combine
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/8 7:25
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rtn = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        add(rtn, list, k, n);
        return rtn;
    }

    public void add(List<List<Integer>> rtn, ArrayList<Integer> list, int k, int n) {
        if (k == 0) {
            rtn.add(new ArrayList<>(list));
            return;
        }
        int last = list.size() >= 1 ? list.get(list.size() - 1) : 0;
        for (int i = last; i < n; i++) {
            list.add(i + 1);
            add(rtn, list, k - 1, n);
            list.remove(list.size() - 1);
        }
    }


    @Test
    public void test() {
        List<List<Integer>> combine = combine(4, 2);

        System.out.println(combine);
        Assert.assertEquals(6, combine.size());
    }
}
