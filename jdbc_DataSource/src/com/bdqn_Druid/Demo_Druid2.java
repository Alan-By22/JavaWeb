package com.bdqn_Druid;

/*
 * @创建人   zby
 * @创建时间 2022/9/13---15:50
 * @描述信息
 */

import com.alibaba.druid.pool.DruidDataSource;
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
public class Demo_Druid2 {
    @Test
    //2.方法的优化
    public void Demo1() {
        //1.导包
        //3
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //读取配置文件
            InputStream inputStream = Demo_Druid.class.getClassLoader().getResourceAsStream("druid.properties");
            //定义一个properties
            Properties properties = new Properties();
            //将流中数据---加载到properties集合中
            properties.load(inputStream);
            //注意--druid的自动解析配置--要求druid.properties中的key---一定是DruidDataSource的属性
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

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
