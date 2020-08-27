package com.example.demo.leetcode;

import org.junit.Test;
import sun.util.calendar.ZoneInfoFile;

import java.util.*;

/**
 * @ClassName CenerateParenthesis
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/26 17:40
 */
public class CenerateParenthesis {
    char left = '(';
    char right = ')';

    public List<String> solution(int n) {
        if (n == 0) {
            return null;
        }
        ArrayList<String> list = new ArrayList<>();
        list.add("(");
        return recursion(list, 1, n - 1, n * 2 - 1);
    }

    public List<String> recursion(List<String> list, int rightNum, int leftNum, int n) {
        List<String> res = new ArrayList<>(list.size());
        List<String> res2 = new ArrayList<>(list.size());
        if (n == 1) {
            for (String val : list) {
                res.add(val + right);
            }
            return res;
        } else {
            if (rightNum == 0) {
                for (String val : list) {
                    res.add(val + left);
                }
                return recursion(res, rightNum + 1, leftNum - 1, n - 1);
            } else {
                HashSet<String> recursion = new HashSet<>();
                if (leftNum > 0) {
                    for (String val : list) {
                        res.add(val + left);
                    }
                    recursion = new HashSet<>(recursion(res, rightNum + 1, leftNum - 1, n - 1));
                }
                for (String val : list) {
                    res2.add(val + right);
                }
                List<String> recursion2 = recursion(res2, rightNum - 1, leftNum, n - 1);
                recursion.addAll(recursion2);
                return new ArrayList<>(recursion);
            }
        }


    }

    @Test
    public void test() {
        List<String> list = new ArrayList<>(Arrays.asList("(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())", "(()())()", "(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()"));
        List<String> solution = solution(4);
        System.out.println(solution);
        for (String s : list) {
            if (!solution.contains(s)) {
                System.err.println(s);
            }
        }
        assert list.equals(solution);

    }
}
