package com.bdqn2.service;

/*
 * @创建人   zby
 * @创建时间 2022/9/9---16:44
 * @描述信息
 */

import com.bdqn.utils.JDBCUtils;
import com.bdqn2.dao.UserDao;
import com.bdqn2.dao.UserDaoImpl;
import com.bdqn2.domain.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//业务层--处理业务
public class UserServiceImpl implements  UserService{
    //创建dao
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void batchAdd(List<User> users) {
        //调用dao
        //事务的开启---注意同一个连接问题
        Connection connection = JDBCUtils.connection();
        try {
            connection.setAutoCommit(false);
            //批量的添加
            for (User user : users) {
                userDao.saveUser(user,connection);
                //System.out.println(10/0);
            }
            //2.提交
            connection.commit();
        } catch (Exception e) {
            //3.回滚
            try {
                connection.rollback();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection,null);
        }
    }
}
