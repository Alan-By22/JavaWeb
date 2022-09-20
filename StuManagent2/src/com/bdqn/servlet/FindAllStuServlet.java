package com.bdqn.servlet;

import com.bdqn.bean.Student;
import com.bdqn.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * @创建人   zby
 * @创建时间 2022/8/25---22:54
 * @描述信息
 */

/**
 * @author 11752
 */
@WebServlet("/findAllStuServlet")
public class FindAllStuServlet extends HttpServlet {
    /** 注入service*/
    private StudentServiceImpl studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //调用service查询数据
        List<Student> list = studentService.findAll();
        //将查询到的数据保存到域对象中
        req.getSession().setAttribute("students",list);
        //跳转到查询页面
        resp.sendRedirect(req.getContextPath()+"/listStu.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
