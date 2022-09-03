package com.bdqn.servlet;

/*
 * @创建人   zby
 * @创建时间 2022/8/25---21:53
 * @描述信息
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2.判断数据
        if (username == null || "".equals(username)) {
            //直接跳转
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }
        //3.登陆成功!将用户的信息保存到session中
        req.getSession().setAttribute("username", username);
        //4.跳转首页
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
