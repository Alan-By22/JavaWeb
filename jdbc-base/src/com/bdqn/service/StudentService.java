package com.bdqn.service;

/*
 * @创建人   zby
 * @创建时间 2022/9/7---17:05
 * @描述信息
 */

import com.bdqn.domain.Student;

import java.util.List;

public interface StudentService {

    //1.查询全部
    List<Student> findAll();

    //2.根据ID删除
    Student findById(Integer id);

    //3.添加学生
    int saveStudent(Student student);

    //4.修改学生
    int updateStudent(Student student);

    //5.删除学生
    int deleteStudentById(Integer id);
}
