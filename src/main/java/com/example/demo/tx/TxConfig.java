package com.example.demo.tx;

import org.junit.Test;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.*;

/**
 * @ClassName TxConfig
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/21 10:40
 */
@Configuration
@EnableTransactionManagement
public class TxConfig {
    String JDBC_URL = "jdbc:mysql://localhost:3306/test";
    String JDBC_USER = "root";
    String JDBC_PASSWORD = "root";


    @Test
    public void connect() throws SQLException {
        Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user");

    }

}
