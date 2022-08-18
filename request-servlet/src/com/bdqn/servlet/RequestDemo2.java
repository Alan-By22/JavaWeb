package com.bdqn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

//1.测试HttpServletRequest--请求头---的方法
@WebServlet("/reServlet02")
public class RequestDemo2 extends HttpServlet {
    /*  String getHeader(String name) :根据请求头---值
    Enumeration<String> getHeaderNames():获取所有的请求头
   Enumeration<String> getHeaders(String name) 根据请求头---所有值*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.
        String connection = req.getHeader("Connection");
        System.out.println("connection"+connection);

        //2.
        Enumeration<String> headers = req.getHeaders("Accept-Encoding");
        while (headers.hasMoreElements()){
            String s = headers.nextElement();
            System.out.println(s);
        }

        //3.
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            String value = req.getHeader(s);
            System.out.println(s+"---"+value);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
