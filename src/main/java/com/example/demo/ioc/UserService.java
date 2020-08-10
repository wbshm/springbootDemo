package com.example.demo.ioc;

import com.example.demo.ioc.anotation.MyAutowired;
import com.example.demo.ioc.anotation.MyComponent;

import java.util.Properties;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/10 10:58
 */
@MyComponent
public class UserService {
    @MyAutowired
    private UserDao userDao;

    public void findUser(String name) {
        userDao.findUser(name);
    }

}
