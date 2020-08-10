package com.example.demo.ioc;

/**
 * @ClassName TestIoc
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/10 11:18
 */
public class TestIoc {
    public static void main(String[] args) {
        MyApplicationContext myApplicationContext = new MyApplicationContext();
        UserService userService = (UserService) myApplicationContext.getBean("userService");
        userService.findUser("张三");
    }
}
