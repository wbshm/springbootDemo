package com.example.demo.design.proxy;

/**
 * @ClassName GunDog
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/14 10:47
 */
public class GunDog implements Dog {
    @Override
    public void info() {
        System.out.println("little dog");
    }

    @Override
    public void run() {
        System.out.println("slowly");
    }
}
