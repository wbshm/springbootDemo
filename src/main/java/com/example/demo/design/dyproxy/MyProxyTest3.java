package com.example.demo.design.dyproxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName MyProxyTest3
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/25 14:26
 */
public class MyProxyTest3 {


    @Test
    public void test() {
        Cat cat = new Cat();
        Animal cat1 = (Animal) Proxy.newProxyInstance(cat.getClass().getClassLoader(), cat.getClass().getInterfaces(), MyInvocation3.instance(cat));
        cat1.eat("nihao");
    }
}


class Cat implements Animal {

    @Override
    public void eat(String food) {
        System.out.println("eat " + food);
    }

    @Override
    public void name() {
        System.out.println("my name is eayson");
    }
}


class MyInvocation3 implements InvocationHandler {
    Object object;

    public MyInvocation3(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object invoke = method.invoke(object, args);
        System.out.println("after");
        return invoke;
    }

    public static MyInvocation3 instance(Object obj) {
        return new MyInvocation3(obj);
    }
}
