package com.example.demo.feature.v8.option;

import org.junit.Test;

import java.util.Optional;

public class Demo {

    @Test
    public void test(){
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        System.out.println(girl1);
    }
}
