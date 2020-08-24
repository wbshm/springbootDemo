package com.example.demo.ioc;

import org.omg.CORBA.portable.IndirectionException;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * @ClassName PrivateCar
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/23 21:29
 */
public class PrivateCar {
    private String color;

    protected void drive() {
        System.out.println("driver private car! the color is:" + color);
    }
}

