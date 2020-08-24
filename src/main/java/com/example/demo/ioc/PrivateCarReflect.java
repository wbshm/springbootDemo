package com.example.demo.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName PrivateCarReflect
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/23 21:38
 */

public class PrivateCarReflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class<?> clazz = loader.loadClass("com.example.demo.ioc.PrivateCar");
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        PrivateCar car = (PrivateCar) constructor.newInstance();
        Field color = clazz.getDeclaredField("color");
        color.setAccessible(true);
        color.set(car, " color");

        Method drive = clazz.getDeclaredMethod("drive");
        drive.setAccessible(true);
        drive.invoke(car);
        car.drive();
    }
}
