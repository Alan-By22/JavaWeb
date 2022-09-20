package com.bdqn.service;

/*
 * @创建人   zby
 * @创建时间 2022/9/2---15:22
 * @描述信息
 */

import com.bdqn.bean.Student;
import com.bdqn.dao.StudentDao;
import com.bdqn.dao.StudentDaoImpl;

import java.util.List;

/**
 * @author 11752
 */
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();

    /** 添加*/
    @Override
    public int saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    /** 查询*/
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    /** 根据id删除*/
    @Override
    public int deleteById(String sid) {
        return studentDao.deleteById(sid);
    }

    /** 根据id查找*/
    @Override
    public Student findById(String sid) {
        return studentDao.findById(sid);
    }

    /** 删除*/
    @Override
    public int updateStu(Student student) {
        return studentDao.updateStu(student);
    }
}
