package com.bdqn.utils;


import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author 11752
 */
public class JDBCUtils {
    /** 私有构造*/
    private JDBCUtils() {
    }

    private static String driverClass = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;
    private static Connection connection = null;

    //静态代码块
    static {
        try {
            //加载配置文件
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("config.properties");
            //加载properties对象
            Properties properties = new Properties();
            properties.load(inputStream);
            //取值--赋值
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            //加载驱动
            Class.forName(driverClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** 获得连接的方法*/
    public static Connection connection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /** 释放资源*/
    public static void close(Connection connection, Statement statement, ResultSet rs) {
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
       if(statement != null){
           try {
               statement.close();
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

    public static void close(Connection connection, Statement statement) {
        close(connection, statement, null);
    }
}
