package com.bdqn.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1.使用该种方式进行servlet的开发--类--继承HttpServlet
 * 2.重写doget,dopost---在一个方法中调用另一个方法.
 * 3.web.xml---配置映射
 */
public class Servlet02 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("servlet对象创建了");
    }

    //get
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello");
    }
    //post
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("servlet对象销毁了");
    }
}
