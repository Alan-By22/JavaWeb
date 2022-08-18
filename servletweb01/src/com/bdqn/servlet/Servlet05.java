package com.bdqn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断是否是会员与非会员
        String path = req.getRequestURI();
        //2.
        path = path.substring(path.lastIndexOf("/") + 1);
        //3.
        if("hy".equals(path)){
            System.out.println("免费");
        }else if("fhy".equals(path)){
            System.out.println("10元运费");
        }else{
            System.out.println("....");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
