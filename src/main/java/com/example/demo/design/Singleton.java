package com.example.demo.design;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName SingleTon
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/6 17:02
 */
public class Singleton {
    /**
     * 懒汉模式
     */
    private static Singleton singleton;

    private Singleton() {
        System.out.println("create");
    }

    public static Singleton newInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        ExecutorService exc = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            exc.execute(() -> {
                Singleton.newInstance();
            });
        }
        exc.shutdown();
    }
}
