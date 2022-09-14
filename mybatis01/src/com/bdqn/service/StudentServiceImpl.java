package com.bdqn.service;

/*
 * @创建人   zby
 * @创建时间 2022/9/14---17:25
 * @描述信息
 */

import com.bdqn.bean.Student;
import com.bdqn.mapper.StudentMapper;
import com.bdqn.mapper.StudentMapperImpl;

import java.util.List;

/**
 * @author 11752
 */
public class StudentServiceImpl implements StudentService{
    /**在业务成注入dao---mapper*/
    private StudentMapper studentMapper = new StudentMapperImpl();

    @Override
    public List<Student> findAll() {
        return  studentMapper.findAll();

    }

    @Override
    public List<Student> findNameLike(String name) {
        return studentMapper.findNameLike(name);
    }

}
