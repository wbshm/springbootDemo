package com.example.demo.leetcode.num;

import org.junit.Test;

import java.util.Arrays;

public class SortColors {
        int[] nums;

        public void sortColors(int[] nums) {
            int i = 0;
            int j = nums.length - 1;
            this.nums = nums;
            int index = 0;
            while (index < nums.length) {
                switch (nums[index]) {
                    case 0:
                        while (i < index && i <= j) {
                            if (nums[i] == 0) {
                                i++;
                            } else {
                                swap(i, index);
                                break;
                            }
                        }
                        index++;
                        break;
                    case 1:
                        index++;
                        break;
                    case 2:
                        boolean rtn = true;
                        while (j > i && j > index) {
                            if (nums[j] == 2) {
                                j--;
                            } else {
                                swap(index, j);
                                rtn = false;
                                break;
                            }
                        }
                        if (rtn) {
                            return;
                        }
                        break;
                }
            }
        }

        public void swap(int i, int j) {
            int t = this.nums[i];
            this.nums[i] = this.nums[j];
            this.nums[j] = t;
        }

    @Test
    public void test() {
        int[] in = new int[]{0,1,2,1};
        sortColors(in);
        System.out.println(Arrays.toString(in));
    }
}
