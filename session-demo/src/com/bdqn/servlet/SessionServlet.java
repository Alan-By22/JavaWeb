package com.bdqn.servlet;

/*
 * @创建人   zby
 * @创建时间 2022/8/23---15:02
 * @描述信息
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session/s1")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建session
        HttpSession session = req.getSession();
        /*
         * 1.获取浏览器传过来的cookie-JSESSIONID=值
         * 有--JSESSIONID--值----找到session
         * 2.浏览器没有jsessionid 或者没有找到session
         * 创建新的session对象--自动生成一个sessionId--自动的向浏览器set_cookie
         * cookie的名字--JSESSIONID--值--sessionId
         *
         * */

        session.setAttribute("name", "lisi");//存在
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
