package com.bdqn.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

//使用流的方法获取数据--post
@WebServlet("/reServlet04")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获得字符流--
        // reader(req);
        //2.字节流
        ServletInputStream inputStream = req.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));
        }
    /*   //2.//get
        String queryString = req.getQueryString();
        System.out.println(queryString);*/

    }

    private void reader(HttpServletRequest req) throws IOException {
        BufferedReader reader = req.getReader();
        String str;
        while ((str = reader.readLine())!= null){
            System.out.println(str);
        }
        System.out.println("-----------------------------------------");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
