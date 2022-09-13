package com.bdqn_Druid;

/*
 * @创建人   zby
 * @创建时间 2022/9/13---15:50
 * @描述信息
 */

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

//测试阿里提供的数据库连接池---Druid
public class Demo_Druid3 {
    @Test
    //2.方法的优化
    public void Demo1() {
        //1.导包
        //3
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //获得连接
            connection = JDBCUtils_Druid.getConnection();
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
           JDBCUtils_Druid.close(connection,preparedStatement,resultSet);

        }
    }
}
