package com.bdqn.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//Response的使用
@WebServlet("/response01")
public class ResponseServlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用字符流乱码
        /*
        请求: 浏览器-- 服务端--学生信息--一顿操作------结果
        响应: response--服务端--浏览器
         */
        String str = "我是字节流响应";
        //字节流
        ServletOutputStream outputStream = response.getOutputStream();
        //输出 str.getBytes()--无参的方法--默认使用系统的编码集--gbk
        response.setContentType("text/html;charset=utf-8");
        outputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
