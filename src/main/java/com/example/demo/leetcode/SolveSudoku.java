package com.example.demo.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class SolveSudoku {
    char[][] board;
    char[][][] prob;

    public void solveSudoku(char[][] board) {
        this.board = board;

    }

    public void check() {
        for (char i = '1'; i < '9'; i++) {
            
        }

    }

    @Test
    public void test() {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '.', '9'},
        };
        System.out.println(Arrays.deepToString(board));
    }
}
