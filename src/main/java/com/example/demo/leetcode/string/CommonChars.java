package com.example.demo.leetcode.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonChars {
    public List<String> commonChars(String[] A) {
        char start = 'a';
        int[] count = new int[26];
        int[] tmp;
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String s : A) {
            tmp = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = (char) (s.charAt(i) - start);
                tmp[c]++;
            }
            for (int i = 0; i < 26; i++) {
                count[i] = Math.min(count[i], tmp[i]);
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                char c = (char) (start + i);
                list.add(Character.toString(c));
            }
        }
        return list;
    }

    @Test
    public void test() {
        String[] in = new String[]{"bella", "label", "roller"};
        List<String> strings = commonChars(in);
        System.out.println(strings);
    }
}
