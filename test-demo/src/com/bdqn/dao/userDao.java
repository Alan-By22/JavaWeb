package com.bdqn.dao;

import com.bdqn.pojo.User;

import java.util.List;

public interface userDao {
//    查询所有
    List<User> userList();
//    登录 查询账号 密码是否存在
    User selUser(String username,String password);
// 注册   查询账号
    User selUsername(String username);
//根据id查找
    User selUser(int id);
//    删除
    boolean delUser(int id);
//    修改
    boolean update (User user);
//    添加
    boolean addUser(User user);
}