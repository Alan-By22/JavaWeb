package com.bdqn_Druid;

/*
 * @创建人   zby
 * @创建时间 2022/9/13---16:32
 * @描述信息
 */

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

//Druid的工具类
public class JDBCUtils_Druid {

    //私有构造
    private JDBCUtils_Druid() {
    }

    //定义
    private static DataSource dataSource = null;

    //2.
    static {
        try {
            //获得输入流
            InputStream inputStream = JDBCUtils_Druid.class.getClassLoader().getResourceAsStream("druid.properties");
            //定义properties
            Properties properties = new Properties();
            //加载数据到--prop
            properties.load(inputStream);
            //获得数据库连接池
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //3.获得连接
    public static Connection getConnection(){
        Connection connection = null;
        try {
             connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    //4.释放资源
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet rs){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //5.释放资源
    public static void close(Connection connection, PreparedStatement preparedStatement){
        close(connection,preparedStatement,null);
    }

}
