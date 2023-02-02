package com.ithuipu.dao;

import com.ithuipu.bean.User;
import com.ithuipu.utils.JDBCUtils_Druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @className: UserDao
 * @author: Mr.BingYu
 * @description:
 * @date: 2023/02/02 14:32
 **/

/**
 * 数据的持久层---把数据放到数据库
 */
public class UserDaoImpl implements UserDao {
    @Override
    public ArrayList<User> findByUsername(String username) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<>();
        try {
            //1.
            connection = JDBCUtils_Druid.getConnection();
            //2.
            String sql = "select * from user where name like ? order by search_count desc";
            preparedStatement = connection.prepareStatement(sql);
            //3.赋值
            preparedStatement.setString(1, "%" + username + "%");
            //4.执行
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_Druid.close(connection, preparedStatement, rs);
        }
        return list;
    }
}
