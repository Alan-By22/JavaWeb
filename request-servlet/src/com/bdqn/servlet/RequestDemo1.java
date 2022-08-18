package com.bdqn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//1.测试HttpServletRequest--路径的方法
@WebServlet("/requestServlet")
public class RequestDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.关于路径
        /*
        getContextPath()  获得虚拟目录
        getRequestURI()  请求的uri(虚拟目录/servlet的路径)/stu/addServlet
        getRequestURL()  请求的路径(全路径) http://localhost:8080/stu/addServlet
        getQueryString() 请求的参数的字符串
        getServletPath()  获得servlet的映射路径
        getRemoteAddr() 访问者的ip

        contextPath:/request
        requestURI:/request/requestServlet
        requestURL:http://localhost/request/requestServlet
        queryString:username=111&age=222
        servletPath:/requestServlet
        remoteAddr:0:0:0:0:0:0:0:1
         */
        //1.
        String contextPath = req.getContextPath();
        System.out.println("contextPath:" + contextPath);
        //2.
        String requestURI = req.getRequestURI();
        System.out.println("requestURI:" + requestURI);
        //3.
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL:" + requestURL.toString());
        //4.
        String queryString = req.getQueryString();
        System.out.println("queryString:" + queryString);
        //5.
        String servletPath = req.getServletPath();
        System.out.println("servletPath:" + servletPath);
        //6.
        String remoteAddr = req.getRemoteAddr();
        System.out.println("remoteAddr:" + remoteAddr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
