package com.example.demo.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName KidsWithCandies
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/9 21:39
 */
public class KidsWithCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = Arrays.stream(candies).max().getAsInt();
        for (int c : candies) {
            res.add(c + extraCandies >= max);
        }
        return res;
    }

    @Test
    public void test() {
        int[] candies = new int[]{2, 3, 5, 1, 3};
        List<Boolean> booleans = kidsWithCandies(candies, 3);
        System.out.println(booleans);
        candies = new int[]{4, 2, 1, 1, 2};
        booleans = kidsWithCandies(candies, 1);
        System.out.println(booleans);
    }
}
