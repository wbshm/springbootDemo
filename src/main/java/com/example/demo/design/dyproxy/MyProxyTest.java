package com.example.demo.design.dyproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName MyProxyTest
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/23 16:09
 */
public class MyProxyTest {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Animal animal = (Animal) AnimalProxyFactory.getProxyInstance(dog);
        animal.eat("hanbegger");

    }
}

interface Animal {
    void eat(String food);

    void name();
}

class Dog implements Animal {

    @Override
    public void eat(String food) {
        System.out.println("dog eat " + food);
    }

    @Override
    public void name() {
        System.out.println("lucy");
    }
}

class MyInvocation implements InvocationHandler {
    private Object animal;

    public MyInvocation(Object animal) {
        this.animal = animal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object invoke = method.invoke(animal, args);
        System.out.println("after");
        return invoke;
    }
}


class AnimalProxyFactory {
    public static Object getProxyInstance(Object proxyObj) {
        MyInvocation myInvocation = new MyInvocation(proxyObj);
        return Proxy.newProxyInstance(proxyObj.getClass().getClassLoader(), proxyObj.getClass().getInterfaces(), myInvocation);
    }
}
