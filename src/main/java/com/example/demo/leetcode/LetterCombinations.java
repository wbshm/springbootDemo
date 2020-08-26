package com.example.demo.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName LetterCombinations
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/26 16:03
 */
public class LetterCombinations {

    public List<String> combinations(String digits) {
        Map<Character, List<String>> map = new HashMap<>(8);
        map.put('2', Arrays.asList("a b c".split(" ")));
        map.put('3', Arrays.asList("d e f".split(" ")));
        map.put('4', Arrays.asList("g h i".split(" ")));
        map.put('5', Arrays.asList("j k l".split(" ")));
        map.put('6', Arrays.asList("m n o".split(" ")));
        map.put('7', Arrays.asList("p q r s".split(" ")));
        map.put('8', Arrays.asList("t u v".split(" ")));
        map.put('9', Arrays.asList("w x y z".split(" ")));
        LinkedList<String> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length(); i++) {
            List<String> strings = map.get(digits.charAt(i));
            if (!res.isEmpty()) {
                while (!res.isEmpty()) {
                    String remove = res.remove(0);
                    for (String s : strings) {
                        sb.append(remove).append(s).append(" ");
                    }
                }
                res = new LinkedList<>(Arrays.asList(sb.toString().split(" ")));
                sb = new StringBuilder();
            } else {
                res = new LinkedList<>(strings);
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println();
    }
}
