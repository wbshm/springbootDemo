package com.example.demo.leetcode.string;

import org.junit.Test;

public class NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        int sum = 0;
        for (int i = 0; i < S.length(); i++) {
            sum += J.indexOf(S.charAt(i)) >= 0 ? 1 : 0;
        }
        return sum;
    }

    @Test
    public void test() {
        String j = "Aa";
        String s = "Aaasweroi";
        int i = numJewelsInStones(j, s);
        System.out.println(i);
    }
}
