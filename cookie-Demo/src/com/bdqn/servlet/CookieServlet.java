package com.bdqn.servlet;

/*
 * @创建人   zby
 * @创建时间 2022/8/22---17:03
 * @描述信息
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookie/c1")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取cookie
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        //获取所有的cookie---cookie客户端的技术--携带cookie---req获取
        Cookie[] cookies = req.getCookies();
        String value = null;
        if (cookies != null) {
            //遍历cookie
            for (Cookie cookie : cookies) {
                //判断是不是我们的cookie
                if ("time".equals(cookie.getName())) {
                    //取值--上次的时间
                    value = cookie.getValue();
                    //获得当前时间
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    value = sdf.format(new Date(Long.parseLong(value)));
                }
            }
        }

        //判断
        if (value == null) {
            pw.println("您是第一次访问本网站");
        } else {
            pw.println("上次您的访问时间是:" + value);
        }

        //创建cookie---当前时间
        Cookie cookie = new Cookie("time", System.currentTimeMillis() + "");
        //设置cookie的有效时间
        //cookie.setMaxAge(30);//秒
        //记得将创建的cookie响应到浏览器--resp
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
