package com.bdqn.mapper;

import com.bdqn.bean.Classes;
import com.bdqn.bean.Student;

import java.util.List;

/**
 * @author 11752
 * @创建人 zby
 * @创建时间 2022/9/16---17:45
 * @描述信息
 */

public interface ManyToManyMapper {

    /** 查询所有*/
    List<Student> findAll();
}
