package com.bdqn_Druid;

/*
 * @创建人   zby
 * @创建时间 2022/9/13---15:50
 * @描述信息
 */

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//测试阿里提供的数据库连接池---Druid
public class Demo_Druid {
    @Test
    //最原始的方案
    public void Demo1() {
        //1.导包
        //2.创建连接池
        DruidDataSource dataSource = new DruidDataSource();
        //3
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //添加路径
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql:///db2");
            dataSource.setUsername("root");
            dataSource.setPassword("123456789");
            //获得连接
            connection = dataSource.getConnection();
            //获得执行sql的对象
            String sql = "select * from user where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            //赋值
            preparedStatement.setInt(1, 3);
            //执行
            resultSet = preparedStatement.executeQuery();
            //处理结果
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username") + "\t" + resultSet.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
