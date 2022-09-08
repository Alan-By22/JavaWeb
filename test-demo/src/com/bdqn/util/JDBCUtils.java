package com.bdqn.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

//工具类
/*
1.加载驱动
2.获得连接
3.释放资源
 */
public class JDBCUtils {
    //1.私有构造
    private JDBCUtils() {
    }

    //2.定义属性
    private static String driverClass=null;
    private static String url=null;
    private static String username=null;
    private static String password=null;
    private static Connection connection = null;

    //3.静态代码块
    static {
        try {
            //1.加载配置文件
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("config.properties");
            //2.加载properties的对象
            Properties prop = new Properties();
            prop.load(inputStream);
            //3.取值--赋值
             driverClass = prop.getProperty("driverClass");
             url = prop.getProperty("url");
             username = prop.getProperty("username");
             password = prop.getProperty("password");
            //4.加载驱动
            Class.forName(driverClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //4.获得连接的方法
    public static Connection getConnection(){
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    //5.释放资源
    public static void close(Connection connection, Statement statement, ResultSet rs){
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

    //6.释放资源
    public static void close(Connection connection, Statement statement){
        close(connection,statement,null);
    }
}
