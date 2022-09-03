package com.bdqn.service;

/*
 * @创建人   zby
 * @创建时间 2022/9/2---15:21
 * @描述信息
 */

import com.bdqn.bean.Student;

import java.util.List;

public interface StudentService {
    //1.添加
    int saveStudent(Student student);
    //2.查询
    List<Student> findAll();
    //3.根据id删除
    int deleteById(String sid);

    //4.根据id查询
    Student findById(String sid);

    //根据id修改
    int updateStu(Student student);
}
