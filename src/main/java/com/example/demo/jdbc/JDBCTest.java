package com.example.demo.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ClassName JDBCTest
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/23 0:26
 */
public class JDBCTest {

    @Test
    public void connect1() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/test";
        Driver driver = DriverManager.getDriver(url);
        Properties info = new Properties();
        info.put("user", "root");
        info.put("password", "root");
        Connection connect = driver.connect(url, info);
        System.out.println(connect);
    }
}
