package com.bdqn;

/*
 * @创建人   zby
 * @创建时间 2022/9/12---13:50
 * @描述信息
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo_c3p0_1 {
    public static void main(String[] args) {
        //导包--c3p0与数据库驱动
        //创建数据库连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //3.
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql:///db2");
            dataSource.setUser("root");
            dataSource.setPassword("123456789");
            //取对象
            connection = dataSource.getConnection();
            //获取对象
            String sql = "select * from user where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            //赋值
            preparedStatement.setInt(1, 3);
            //执行
            resultSet = preparedStatement.executeQuery();
            //遍历数据
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username") + "\t" + resultSet.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
