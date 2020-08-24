package com.example.demo.ioc;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectTest
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/23 21:00
 */
public class ReflectTest {
    public Car initByDefaultConst() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /**
         * 1. 通过类装载器获取Car类对象
         * 2. 获取类的默认构造器对象并通过它实例化Car
         * 3. 通过反射方法设置属性
         */
//        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        ClassLoader loader = this.getClass().getClassLoader();
        Class<?> clazz = loader.loadClass("com.example.demo.ioc.Car");
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Car car = (Car) constructor.newInstance();

        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "红旗 H9");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "black");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 200);
        return car;
    }

    @Test
    public void test() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Car car = initByDefaultConst();
        car.introduce();
    }
}
