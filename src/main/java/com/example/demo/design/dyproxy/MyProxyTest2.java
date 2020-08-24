package com.example.demo.design.dyproxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName MyProxyTest2
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/23 16:25
 */
public class MyProxyTest2 {

    @Test
    public void test() {
//        People teacher = new Teacher();
//        People people = (People) ProxyFactory2.getProxyInstance(teacher);
//        people.doWhat();


        SuperMan superMan = new SuperMan();
        Human human = (Human) ProxyFactory2.getProxyInstance(superMan);
        human.eat("nihao");
//        System.out.println(people.age());
    }
}

/**
 * 1. 需要一个接口类
 * 2. 需要一个实现对应接口的类
 * 3. 需要一个实现InvocationHandler接口的类。
 * 4. 需要一个代理工厂类
 */

interface People {
    void doWhat();

    int age();
}


class Teacher implements People {

    @Override
    public void doWhat() {
        System.out.println("teach student");
    }

    @Override
    public int age() {
        return 30;
    }
}

class MyInvocation2 implements InvocationHandler {

    private Object object;

    public MyInvocation2(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object invoke = method.invoke(object, args);
        System.out.println("after");
        return invoke;
    }
}

class ProxyFactory2 {
    public static Object getProxyInstance(Object obj) {
        MyInvocation2 myInvocation2 = new MyInvocation2(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), myInvocation2);
    }
}

