package com.bdqn.servlet;

/*
 * @创建人   zby
 * @创建时间 2022/8/23---15:02
 * @描述信息
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/session/s2")
public class SessionServlet2 extends HttpServlet {
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
        //2.
        String id = session.getId();
        Cookie cookie = new Cookie("JSESSIONID", id);
        cookie.setMaxAge(1000);
        resp.addCookie(cookie);
        Object name = session.getAttribute("name");
        System.out.println("s2的name:" + name);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
