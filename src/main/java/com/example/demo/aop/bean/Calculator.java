package com.example.demo.aop.bean;

import com.example.demo.aop.it.CalculatorInterface;
import org.springframework.stereotype.Component;

/**
 * @ClassName Calculator
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/20 23:03
 */
@Component
public class Calculator implements CalculatorInterface {


    @Override
    public int div(int i, int j) {
        return i / j;
    }


//    public int div2(int i, int j) {
//        return div(i, j);
//    }
}
