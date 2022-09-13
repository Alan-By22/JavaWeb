package com.bdqn;

/*
 * @创建人   zby
 * @创建时间 2022/9/13---12:22
 * @描述信息
 */


import com.mchange.v2.c3p0.ComboPooledDataSource;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils_c3p0 {
    //私有构造
    private JDBCUtils_c3p0() {
    }

    private static DataSource dataSource = null;

    //2.
    static {
        dataSource = new ComboPooledDataSource();
    }

    //3.获得连接
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //4.释放资源
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet rs) {
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

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //5.释放资源
    public static void close(Connection connection, PreparedStatement preparedStatement) {
        close(connection, preparedStatement, null);
    }
}
