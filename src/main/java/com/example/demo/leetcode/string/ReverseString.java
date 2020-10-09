package com.example.demo.leetcode.string;

import org.junit.Test;

import java.util.Arrays;

public class ReverseString {
    public void reverseString(char[] s) {
        int loop = 0;
        int max = s.length / 2;
        while (loop < max) {
            char c = s[loop];
            s[loop] = s[s.length - 1 - loop];
            s[s.length - 1 - loop] = c;
            loop++;
        }
    }

    @Test
    public void test() {
        String test = "abcd";
        char[] chars = test.toCharArray();
        reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }
}
