package com.example.demo.ioc.anotation;

/**
 * @ClassName MyComponet
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/10 10:43
 */

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface MyComponent {
    String value() default "";
}
