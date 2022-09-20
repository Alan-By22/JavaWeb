package com.bdqn.servlet;


import com.bdqn.bean.Student;
import com.bdqn.service.StudentService;
import com.bdqn.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 11752
 */
@WebServlet("/addStuServlet")
public class AddStuServlet extends HttpServlet {

    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收
        req.setCharacterEncoding("utf-8");
        String sid = req.getParameter("sid");
        String name = req.getParameter("name");
        String score = req.getParameter("score");
        //2.service
        int i = studentService.saveStudent(new Student(sid, name, Integer.parseInt(score)));
        if (i > 0) {
            //添加成功
            resp.getWriter().println("添加成功,2秒后跳转到首页");
            resp.setHeader("Refresh", "2;URL=" + req.getContextPath() + "/index.jsp");
        } else {
            //添加失败
            req.getSession().setAttribute("error", "添加失败");
            resp.sendRedirect(req.getContextPath() + "/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
