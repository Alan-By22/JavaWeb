package com.bdqn.web;

import com.bdqn.bean.User;
import com.bdqn.service.UserServiceImpl;
import com.bdqn.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findidServlet")
public class findidServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");  //post 解决乱码
        String id = request.getParameter("id");
        userService us = new UserServiceImpl();
        User user = us.selUser(Integer.parseInt(id));

        if (user != null){
            // 找到了有这个信息
            request.setAttribute("user", user);
            String contextPath = request.getContextPath();
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        }else {
            request.setAttribute("msg", "修改失败~请查看日志文件");
            request.getRequestDispatcher("/selectAllServlet").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
