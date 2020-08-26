package com.example.demo.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName CenerateParenthesis
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/26 17:40
 */
public class CenerateParenthesis {
    public List<String> solution(int n) {
        String left = "(";
        String right = ")";

        StringBuilder sb;
        if (n == 1) {
            return new ArrayList<>(Collections.singletonList(left + right));
        } else {
            sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(left).append(right);
            }

        }
        // TODO: 2020/8/26 还未解决
        return null;
    }

    @Test
    public void test() {
        List<String> list = new ArrayList<>(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"));
        List<String> solution = solution(3);
        assert list.equals(solution);

    }
}
