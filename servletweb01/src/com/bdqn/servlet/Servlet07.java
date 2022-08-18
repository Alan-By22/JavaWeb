package com.bdqn.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet07 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获得servletContext对象
        ServletContext servletContext = getServletContext();
        //2.获得公共初始化参数
        String address = servletContext.getInitParameter("address");
        System.out.println("Servlet07----address:"+address);
        //3.域对象--存值---作用的范围--当前的应用
        servletContext.setAttribute("java","v2214");
        //4.获得项目的虚拟目录
        String contextPath = servletContext.getContextPath();
        System.out.println("contextPath:"+contextPath);

        //5.获得当前文件的绝对路径
        String realPath = servletContext.getRealPath("/a.txt");
        System.out.println(realPath);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
