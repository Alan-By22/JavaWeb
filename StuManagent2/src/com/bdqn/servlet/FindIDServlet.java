package com.bdqn.servlet;

/*
 * @创建人   zby
 * @创建时间 2022/9/2---15:50
 * @描述信息
 */

import com.bdqn.bean.Student;
import com.bdqn.service.StudentService;
import com.bdqn.service.StudentServiceImpl;
import com.sun.tools.javac.Main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.invoke.VarHandle;

/**
 * @author 11752
 */
public class FindIDServlet extends HttpServlet {

    /**
     * 注入service
     */
    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /** 接收数据*/
        String sid = req.getParameter("sid");
        /** service查询*/
        Student student = studentService.findById(sid);
        /** 将数据存到域对象中*/
        req.getSession().setAttribute("stu", student);
        /** 页面的跳转只能用转发*/
        resp.sendRedirect(req.getContextPath() + "/update.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
