package com.bdqn_callable;

/*
 * @创建人   zby
 * @创建时间 2022/9/13---16:51
 * @描述信息
 */

import com.bdqn_Druid.JDBCUtils_Druid;
import org.junit.Test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

//测试--jdbc--存储过程
public class Demo_callable {

    @Test
    public void demo() {
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        try {
            //1.获得连接
            connection = JDBCUtils_Druid.getConnection();
            //2.数据库创建存储过程
            //3.connection创建存储过程的对象
            callableStatement = connection.prepareCall("{call user_call()}");
            //4.执行
            resultSet = callableStatement.executeQuery();
            //5.处理结果
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username") + "\t" + resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_Druid.close(connection, callableStatement, resultSet);
        }
    }
}
