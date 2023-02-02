package com.ithuipu.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ithuipu.bean.User;
import com.ithuipu.service.UserService;
import com.ithuipu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @className: SearchServlet
 * @author: Mr.BingYu
 * @description:
 * @date: 2023/02/02 14:22
 **/

/**
 * 表现层--只跟浏览器交互
 */
@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {

    //注入service
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收数据
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //2.
        String username = req.getParameter("username");
        //3.service
        ArrayList<User> arrayList = userService.findByUsername(username);
        //4.list--json
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(arrayList);
        //响应
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
