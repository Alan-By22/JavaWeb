package com.ithuipu.service;

import com.ithuipu.bean.User;

import java.util.ArrayList;

/**
 * @className: UserService
 * @author: Mr.BingYu
 * @description:
 * @date: 2023/02/02 14:31
 **/

public interface UserService {
    ArrayList<User> findByUsername(String username);
}
