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

@WebServlet("/addServlet")
public class addServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");  //post 解决乱码
        userService us = new UserServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String address = request.getParameter("address");
        User u = new User(username,password,Integer.parseInt(age),address);
        boolean b = us.addUser(u);
        if (b){
            // 添加成功
            request.setAttribute("msg", "添加成功~");
            // 重新查询数据  刷新
            request.getRequestDispatcher("/selectAllServlet").forward(request, response);

        }else {
            request.setAttribute("msg", "添加失败~");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
