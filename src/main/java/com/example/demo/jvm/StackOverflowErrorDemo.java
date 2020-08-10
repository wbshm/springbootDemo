package com.example.demo.jvm;

/**
 * @ClassName StackOOM
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/7 11:15
 */
public class StackOverflowErrorDemo {
    private static int count;

    public static void main(String[] args) {
        try {
            method();
        } catch (StackOverflowError e) {
            e.printStackTrace();
            System.out.println(count);
        }
    }

    private static void method() {
        count++;
        method();
    }
}
