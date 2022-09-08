package com.bdqn.service;

/*
 * @创建人   zby
 * @创建时间 2022/9/7---17:06
 * @描述信息
 */


import com.bdqn.dao.StudentDao;
import com.bdqn.dao.StudentDaoImpl;
import com.bdqn.domain.Student;

import java.util.List;

//业务层
public class StudentServiceImpl implements StudentService {
    //注入service
    private StudentDao studentDao = new StudentDaoImpl();

    //查询全部
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    //2.id查询
    @Override
    public Student findById(Integer id) {
        return studentDao.findById(id);
    }

    //添加学生
    @Override
    public int saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    //修改学生
    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    //删除学生
    @Override
    public int deleteStudentById(Integer id) {
        return studentDao.deleteStudentById(id);
    }
}
