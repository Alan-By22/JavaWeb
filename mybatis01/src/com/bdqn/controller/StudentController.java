package com.bdqn.controller;

/*
 * @创建人   zby
 * @创建时间 2022/9/14---17:24
 * @描述信息
 */

import com.bdqn.bean.Student;
import com.bdqn.service.StudentService;
import com.bdqn.service.StudentServiceImpl;
import com.bdqn.test.StudentTest;
import org.junit.Test;

import java.util.List;

/** web表现层
 * @author 11752*/
public class StudentController {

    /**在web层中注入service*/
    private StudentService studentService = new StudentServiceImpl();

    /**查询所有*/
    @Test
    public void findAll(){
        //调用service
        List<Student> list = studentService.findAll();
        //遍历
        list.forEach(System.out::println);
    }
    /**模糊查询*/
    @Test
    public void findNameLike(){
        String name = "%妮%";
        List<Student> list = studentService.findNameLike(name);
        //遍历
        list.forEach(System.out::println);
    }
}
