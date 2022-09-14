package com.bdqn.web;

import com.bdqn.bean.User;
import com.bdqn.service.UserServiceImpl;
import com.bdqn.service.userService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userService us = new UserServiceImpl();
        List<User> users = us.userList();

//        获取session域
        HttpSession session = request.getSession();
        session.setAttribute("userAll",users);
        String contextPath = request.getContextPath(); //当前项目路径
        response.sendRedirect(contextPath+"/userall.jsp");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
