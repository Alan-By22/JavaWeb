package com.ithuipu.service;

/**
 * @className: UserServiceImpl
 * @author: Mr.BingYu
 * @description:
 * @date: 2023/02/02 14:32
 **/

import com.ithuipu.bean.User;
import com.ithuipu.dao.UserDao;
import com.ithuipu.dao.UserDaoImpl;

import java.util.ArrayList;

/**
 * 业务层
 */
public class UserServiceImpl implements UserService{
    //注入dao
    private UserDao userDao = new UserDaoImpl();
    @Override
    public ArrayList<User> findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}

