package com.bdqn2.dao;

/*
 * @创建人   zby
 * @创建时间 2022/9/9---16:43
 * @描述信息
 */

import com.bdqn2.domain.User;

import java.sql.Connection;

public interface UserDao {
    void saveUser(User user, Connection connection);
}
