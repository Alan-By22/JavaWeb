package com.bdqn2.dao;

/*
 * @创建人   zby
 * @创建时间 2022/9/9---16:44
 * @描述信息
 */

import com.bdqn.utils.JDBCUtils;
import com.bdqn2.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;


//数据持久层
public class UserDaoImpl implements UserDao {
    //用户添加
    @Override
    public void saveUser(User user, Connection connection) {

        PreparedStatement preparedStatement = null;
        try {
            //获取预编译对象
            preparedStatement = connection.prepareStatement("insert into user values(null,?,?)");
            //设置参数
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            //执行
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement);
        }

    }
}
