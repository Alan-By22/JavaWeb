package com.bdqn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发 与 重定向的区别
 * 1.行为: 请求转发(服务端的行为) ,重定向(浏览器的行为)
 * 2.请求次数 : 请求转发(1次)  重定向(2次)
 * 3.地址栏: 请求转发(不会变)  重定向(会变)
 * <p>
 * 举例:
 * 转发: 小李--小王--借钱---(小王没有--去找朋友小赵--获得到钱)---小李
 * 重定向:  小李--小王--借钱---小王没有--告诉小李小赵有-----小李去找小赵
 */

@WebServlet("/Response06")
public class ResponseServlet06 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取值
        Object name = request.getAttribute("name");
        System.out.println(name);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("地址栏改变,到我了");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}