package com.ithuipu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: AjaxServlet
 * @author: Mr.BingYu
 * @description:
 * @date: 2023/02/01 15:55
 **/

/**
 * 服务端
 */
@WebServlet("/ajaxServlet")
public class AjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");


        //1.接收数据
        String username = req.getParameter("username");
        //2.校验
        //---service---dao----数据库
        if ("lisi".equals(username)) {
            //存在---用户已经注册
            //3.响应
            resp.getWriter().write("<font color='red'>用户名已经被注册</font>");
        } else {
            resp.getWriter().write("<font color='green'>用户名正常</font>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
