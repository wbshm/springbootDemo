package com.example.demo.jdbc;

import java.sql.*;

/**
 * @ClassName MyJdbc
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/10 21:53
 */
public class MyJdbc {
    String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
    String JDBC_USER = "root";
    String JDBC_PASSWORD = "root";

    public void select() {
        try {
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, grade, name, gender FROM students WHERE gender=1");
            while (rs.next()) {
                long id = rs.getLong(1); // 注意：索引从1开始
                long grade = rs.getLong(2);
                String name = rs.getString(3);
                int gender = rs.getInt(4);
                System.out.println(id + "," + grade + "," + name + "," + gender + ";");
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyJdbc myJdbc = new MyJdbc();
        myJdbc.select();
    }
}
