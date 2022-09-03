package com.bdqn.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/*
 * @创建人   zby
 * @创建时间 2022/9/2---12:16
 * @描述信息
 */
//工具类
/*
1.加载驱动
2.获得连接
3.释放资源
*/
public class JDBCUtils {
    //私有构造
    private JDBCUtils() {

    }

    //定义属性
    private static String driverClass = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;
    private static Connection connection = null;

    //静态代码块
    static {
        try {
            //1.加载配置文件
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("config.properties");
            //2.加载properties对象
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
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //5.释放资源
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (connection == null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement == null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet == null) {
            try {
                resultSet.close();
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
