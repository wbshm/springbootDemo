package com.example.demo.design;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Sington2
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/6 17:09
 */
public class Singleton2 {
    public static Singleton2 singleton2 = new Singleton2();

    private Singleton2() {
        System.out.println("create");
    }

    public static Singleton2 getSingleton2() {
        return singleton2;
    }

    public static void main(String[] args) {
        ExecutorService exc = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            exc.execute(() -> {
                Singleton2.getSingleton2();
            });
        }
        exc.shutdown();
    }
}
