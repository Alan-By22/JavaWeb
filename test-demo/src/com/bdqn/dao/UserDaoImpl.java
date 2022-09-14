package com.bdqn.dao;

import com.bdqn.bean.User;
import com.bdqn.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements userDao {
    Connection connection = JDBCUtils.connection();

    //    查询所有
    @Override
    public List<User> userList() {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select  * from student");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                User user = new User(id, username, password, age, address);
                userList.add(user);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }

    //    登录 查询账号 密码是否存在
    @Override
    public User selUser(String username, String password) {
        User u = null;
        try {
            PreparedStatement prs = connection.prepareStatement("select * from student where username = ? and password = ?");
            prs.setString(1, username);
            prs.setString(2, password);
            ResultSet resultSet = prs.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String user = resultSet.getString("username");
                String pass = resultSet.getString("password");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                u = new User(id1, user, pass, age, address);
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return u;
    }

    // 注册   查询账号
    @Override
    public User selUsername(String username) {
        User u = null;
        try {
            PreparedStatement prs = connection.prepareStatement("select * from student where username = ?");
            prs.setString(1, username);
            ResultSet resultSet = prs.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String user = resultSet.getString("username");
                String pass = resultSet.getString("password");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                u = new User(id1, user, pass, age, address);
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return u;
    }

    //根据id查找
    @Override
    public User selUser(int id) {
        User u = null;   //  将要返回的 user对象
        try {
            PreparedStatement prs = connection.prepareStatement("select * from student where id = ?");
            prs.setInt(1, id);
            ResultSet resultSet = prs.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                u = new User(id1, username, password, age, address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return u;
    }

    //    删除
    @Override
    public boolean delUser(int id) {
        int i = 0;
        try {
            PreparedStatement prs = connection.prepareStatement("delete from student where id = ?");
            prs.setInt(1, id);
            i = prs.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i > 0;
    }

    //    修改
    @Override
    public boolean update(User user) {
        int i = 0;
        try {
            PreparedStatement prs = connection.prepareStatement("update  student set username=? ,password=?,age = ?,address=? where id=?");
            prs.setString(1, user.getUsername());
            prs.setString(2, user.getPassword());
            prs.setInt(3, user.getAge());
            prs.setString(4, user.getAddress());
            prs.setInt(5, user.getId());
            i = prs.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i > 0;
    }

    //    添加
    @Override
    public boolean addUser(User user) {
        int i = 0;
        try {
            PreparedStatement prs = connection.prepareStatement("insert into student values (?,?,?,?,?)");
            prs.setInt(1, user.getId());
            prs.setString(2, user.getUsername());
            prs.setString(3, user.getPassword());
            prs.setInt(4, user.getAge());
            prs.setString(5, user.getAddress());
            i = prs.executeUpdate();  //修改数据的行数 如果是1 就表示成功 否则失败
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i > 0;
    }
}
