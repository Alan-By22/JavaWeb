package com.bdqn.service;

/*
 * @创建人   zby
 * @创建时间 2022/9/14---17:25
 * @描述信息
 */

import com.bdqn.bean.Student;

import java.util.List;

/**
 * @author 11752
 */
public interface StudentService {
    /**查询所有*/
    List<Student> findAll();

    List<Student> findNameLike(String name);
}
