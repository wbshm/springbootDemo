package com.example.demo.design.proxy;

/**
 * @ClassName Test
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/14 10:54
 */
public class Test {
    public static void main(String[] args) {
        Dog target = new GunDog();
        Dog dog = (Dog) MyProxyFactory.getProxy(target);
        dog.info();
        dog.run();
    }
}
