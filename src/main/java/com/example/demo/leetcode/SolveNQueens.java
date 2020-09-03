package com.example.demo.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 51. N 皇后
 * https://leetcode-cn.com/problems/n-queens/
 *
 * @ClassName SolveNQueens
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/3 21:14
 */
public class SolveNQueens {

    public List<List<String>> solveNQueens(int n) {
        LinkedList<int[]> todoList = new LinkedList<>();
        int[] num;
        for (int i = 0; i < n; i++) {
            num = new int[n];
            num[0] = i + 1;
            todoList.add(num);
        }

        ArrayList<int[]> finished = new ArrayList<>();
        while (!todoList.isEmpty()) {
            int[] pop = todoList.remove();
            int next = search(pop, 0);
            if (next == -1) {
                finished.add(pop);
            } else {
                int[] tmp;
                for (int i = 0; i < n; i++) {
                    tmp = Arrays.copyOf(pop, pop.length);
                    if (check(tmp, i + 1, next)) {
                        tmp[next] = i + 1;
                        todoList.add(tmp);
                    }
                }
            }
        }
        List<List<String>> lists = formatRes(finished);
        return formatRes(finished);
    }

    public List<List<String>> formatRes(List<int[]> num) {
        List<List<String>> res = new ArrayList<>();
        List<String> tmp;
        for (int[] n : num) {
            tmp = new ArrayList<>();
            for (int value : n) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n.length; j++) {
                    sb.append(j == value - 1 ? "Q" : ".");
                }
                tmp.add(sb.toString());
            }
            res.add(tmp);
        }
        return res;
    }

    public int search(int[] num, int key) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public boolean check(int[] num, int site, int next) {
        for (int i = 0; i < next; i++) {
            int level = next - i;
            int vertical = num[i] - site;
            if (level == vertical || site == num[i] || level == -vertical) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        solveNQueens(4);
    }
}
