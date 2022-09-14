package com.bdqn.service;

import com.bdqn.dao.UserDaoImpl;
import com.bdqn.dao.userDao;
import com.bdqn.bean.User;

import java.util.List;

public class UserServiceImpl implements userService{
    userDao ud = new UserDaoImpl();
    //    查询所有
    @Override
    public List<User> userList() {
        List<User> users = ud.userList();
        return users;
    }
    //    登录 查询账号 密码是否存在
    @Override
    public User selUser(String username, String password) {
        User user = ud.selUser(username, password);
        return user;
    }

    // 注册   查询账号
    @Override
    public User selUsername(String username) {
        User user = ud.selUsername(username);
        return user;
    }

    //根据id查找
    @Override
    public User selUser(int id) {
        User user = ud.selUser(id);
        return user;
    }

    //    删除
    @Override
    public boolean delUser(int id) {
        boolean b = ud.delUser(id);
        return b;
    }
    //    修改
    @Override
    public boolean update(User user) {
        boolean update = ud.update(user);
        return update;
    }
    //    添加
    @Override
    public boolean addUser(User user) {
        boolean b = ud.addUser(user);
        return b;
    }
}
