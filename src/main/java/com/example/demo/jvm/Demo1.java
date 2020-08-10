package com.example.demo.jvm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Demo1
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/7 11:05
 */
public class Demo1 {
    public static void m1() {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    public static void m2(StringBuilder sb) {
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    public static StringBuilder m3() {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        return sb;
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
//            exec.execute(Demo1::m1);
            exec.execute(() -> m2(sb));
//            exec.execute(() -> {
//                StringBuilder sb1 = m3();
//                System.out.println(sb1);
//            });
        }
    }

}
