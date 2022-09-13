package com.bdqn2.service;

/*
 * @创建人   zby
 * @创建时间 2022/9/9---16:44
 * @描述信息
 */

import com.bdqn2.domain.User;

import java.util.List;

public interface UserService {
    //批量添加
    void batchAdd(List<User> users);
}
