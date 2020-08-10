package com.example.demo.ioc;

import com.example.demo.ioc.anotation.MyComponent;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/10 10:57
 */
@MyComponent
public class UserDao {
    public void findUser(String userName) {
        System.out.println("find a user " + userName);
    }
}
