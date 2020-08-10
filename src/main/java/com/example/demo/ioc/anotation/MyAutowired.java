package com.example.demo.ioc.anotation;

import java.lang.annotation.*;

/**
 * @ClassName MyAutowired
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/10 10:49
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface MyAutowired {

    String value() default "";

}
