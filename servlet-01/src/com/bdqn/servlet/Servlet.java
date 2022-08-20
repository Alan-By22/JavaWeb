package com.bdqn.servlet;

/*
 * @创建人   zby
 * @创建时间 2022/8/20---23:36
 * @描述信息
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //请求对象
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //向浏览器响应
        resp.setContentType("text/html;charset=utf-8");
        //判断查询数据库
        if ("123456".equals(username) && "123456".equals(password)) {
            resp.getWriter().println("登陆成功");
        } else {
            resp.getWriter().println("登陆失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
