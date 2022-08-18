package com.bdqn.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class Servlet06 extends HttpServlet {
    //获得ServletConfig--初始化参数的配置---配置对象
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.根据初始化的名称--值
        String name = config.getInitParameter("name");
        System.out.println("name:" + name);
        //2.获得servlet的名称
        String servletName = config.getServletName();
        System.out.println("servletName:" + servletName);

        //3.获得所有初始化参数名的枚举
        Enumeration<String> enumeration = config.getInitParameterNames();
        while (enumeration.hasMoreElements()) {
            String s = enumeration.nextElement();// 名字
            String value = config.getInitParameter(s);
            System.out.println(s + ":" + value);
        }
        //4.获得servletContext
        ServletContext servletContext = config.getServletContext();
        System.out.println(servletContext);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
