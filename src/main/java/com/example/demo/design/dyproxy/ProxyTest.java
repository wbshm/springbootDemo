package com.example.demo.design.dyproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyTest
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/22 20:06
 */
public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human human = (Human) ProxyFactory.getProxyInstance(superMan);
        String belief = human.getBelief();
        System.out.println(belief);
        human.eat("shit");

    }
}

class ProxyFactory {

    /**
     * 返回一个代理类的对象
     */
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.setObject(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("123");
        Object invoke = method.invoke(object, args);
        System.out.println("321");
        return invoke;
    }
}

interface Human {
    String getBelief();

    void eat(String food);
}


class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "拯救地球";
    }

    @Override
    public void eat(String food) {
        System.out.println("eat air" + food);
    }
}
