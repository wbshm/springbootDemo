package com.example.demo.design.proxy;

import java.lang.reflect.Proxy;

/**
 * @ClassName MyProxyFactory
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/14 10:52
 */
public class MyProxyFactory {

    public static Object getProxy(Object target) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.setTarget(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }
}
