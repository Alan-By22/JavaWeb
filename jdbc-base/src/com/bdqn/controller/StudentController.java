package com.bdqn.controller;

/*
 * @创建人   zby
 * @创建时间 2022/9/7---17:04
 * @描述信息
 */

import com.bdqn.domain.Student;
import com.bdqn.service.StudentService;
import com.bdqn.service.StudentServiceImpl;
import org.junit.Test;


import java.sql.Date;
import java.util.List;

//表现层controller---service---dao--数据库-
public class StudentController {
    //注入service
    private StudentService studentService = new StudentServiceImpl();

    //查询全部
    @Test
    public void findAllDemo() {
        List<Student> list = studentService.findAll();
        System.out.println(list);
    }

    //查询
    @Test
    public void findStudentById() {
        Student byId = studentService.findById(4);
        System.out.println(byId);
    }

    //新增
    @Test
    public void saveStudentById() {

        Date date = new Date(System.currentTimeMillis());
        //创建学生
        Student student = new Student(null, "韩2雪", 18, date);
        System.out.println(student);
        //2.
        int i = studentService.saveStudent(student);
        if (i > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }


    //修改
    @Test
    public void updateStudent() {
        //学生对象
        Student student = studentService.findById(4);
        //修改学生对象
        student.setName("憨憨");
        //修改
        int i = studentService.updateStudent(student);
        if (i > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }


    //删除
    @Test
    public void deleteStudentById() {
        int i = studentService.deleteStudentById(3);
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }
}
