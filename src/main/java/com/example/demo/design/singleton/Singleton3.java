package com.example.demo.design.singleton;

import org.junit.Test;

/**
 * @ClassName Singleton3
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/23 17:11
 */
public class Singleton3 {

    @Test
    public void test() {
        SingletonEnum ins = SingletonEnum.INSTANCE;
        SingletonEnum ins2 = SingletonEnum.INSTANCE;
        System.out.println(ins == ins2);
    }
}

enum SingletonEnum {
    /**
     * 单例模式
     */
    INSTANCE;

    public void sayHello() {
        System.out.println("hello");
    }

}

