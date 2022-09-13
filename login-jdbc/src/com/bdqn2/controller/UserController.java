package com.bdqn2.controller;

/*
 * @创建人   zby
 * @创建时间 2022/9/9---16:43
 * @描述信息
 */

import com.bdqn2.domain.User;
import com.bdqn2.service.UserService;
import com.bdqn2.service.UserServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//表现层--数据--前台携带过来的--假数据
public class UserController {
    //创建UserService对象
    private UserService userService = new UserServiceImpl();
    //批量添加
    @Test
    public void saveBatch(){
        //获取数据
        List<User> list = new ArrayList<>();
        list.add(new User("李四","123"));
        list.add(new User("王五","234"));
        list.add(new User("赵六","345"));

        //调用service处理
        userService.batchAdd(list);
    }
}
