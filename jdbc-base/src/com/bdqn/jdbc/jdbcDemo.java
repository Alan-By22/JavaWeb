package com.bdqn.jdbc;

/*
 * @创建人   zby
 * @创建时间 2022/8/31---10:26
 * @描述信息
 */

import java.sql.*;

public class jdbcDemo {
    public static void main(String[] args) throws Exception {
        find();
        //save();
    }

    //添加
    private static void save() throws ClassNotFoundException, SQLException {
        //添加驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获得连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///db10", "root", "123456789");
        //获得执行sql的对象
        Statement statement = connection.createStatement();
        //执行sql
        String NAME = "韩雪";
        double money = 1600.0;
        String sql = "insert into account values(null,'"+NAME+"',"+money+")";
        int i = statement.executeUpdate(sql);
        //5.
        if (i >0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
        //6.释放资源
        connection.close();
        statement.close();
    }

    //查询
    private static void find() throws ClassNotFoundException, SQLException {
        //1.导包
        //2.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获得连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db10", "root", "123456789");
        //4.获得执行sql的对象
        Statement statement = connection.createStatement();
        //5.执行sql
        String sql = "select * from account";
        ResultSet resultSet = statement.executeQuery(sql);
        //6.处理结果
        while (resultSet.next()){
            System.out.println(resultSet.getInt("id")+
                    "\t"+resultSet.getString("NAME")+
                    "\t"+resultSet.getDouble("money"));
        }
        //7.释放资源
        connection.close();
        statement.close();
        resultSet.close();
    }
}
