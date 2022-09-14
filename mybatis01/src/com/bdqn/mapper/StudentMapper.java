package com.bdqn.mapper;

/*
 * @创建人   zby
 * @创建时间 2022/9/14---17:28
 * @描述信息
 */

import com.bdqn.bean.Student;

import java.util.List;

/**
 * @author 11752
 */
public interface StudentMapper {

    /**查询所有*/
    List<Student> findAll();

    List<Student> findNameLike(String name);
}
