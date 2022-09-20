package com.bdqn.dao;


import com.bdqn.bean.Student;

import java.util.List;

/**
 * @author 11752
 */ //数据持久层
public interface StudentDao {
    //1.添加
    int saveStudent(Student student);
    //2.查询
    List<Student> findAll();
    //3.根据id来删除
    int deleteById(String sid);

    //4.根据id查询
    Student findById(String sid);

    //5.根据id修改
    int updateStu(Student student);
}
