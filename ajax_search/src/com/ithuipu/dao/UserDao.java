package com.ithuipu.dao;

import com.ithuipu.bean.User;

import java.util.ArrayList;

/**
 * @className: UserDao
 * @author: Mr.BingYu
 * @description:
 * @date: 2023/02/02 14:32
 **/


public interface UserDao {
    ArrayList<User> findByUsername(String username);
}
