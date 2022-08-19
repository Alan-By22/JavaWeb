package com.bdqn.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
从一个servlet跳转到另外一个servlet
1.转发与重定向的区别
转发: 服务端的行为,一次请求,地址栏不变
重定向: 浏览器的行为,两次请求,地址栏会发生变化

servlet学习中--存在四个域对象
域对象: 可以共享数据,有范围的对象
1.servletContext -- 范围:整个应用--单例对象
2.request:---范围: 一次请求(转发使用)
 */
@WebServlet("/request06")
public class RequestDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //请求域的域对象的作用范围("一次请求")
        req.setAttribute("name","lisi6666");

        //获得请求的调度对象
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/request07");

        //转发
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
