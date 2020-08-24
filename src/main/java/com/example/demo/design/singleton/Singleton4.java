package com.example.demo.design.singleton;

import org.junit.Test;

/**
 * @ClassName Singleton4
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/23 17:16
 */
public class Singleton4 {
    @Test
    public void test() {
        SingletonStatic instance = SingletonStatic.instance();
        SingletonStatic instance2 = SingletonStatic.instance();
        System.out.println(instance == instance2);
    }
}

class SingletonStatic {

    private SingletonStatic() {
        System.out.println("init");
    }

    private static class InstanceHandler {
        private static final SingletonStatic INSTANCE = new SingletonStatic();
    }

    public static SingletonStatic instance() {
        return InstanceHandler.INSTANCE;
    }

}
