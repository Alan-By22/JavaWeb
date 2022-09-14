package com.bdqn.web;

import com.bdqn.bean.User;
import com.bdqn.service.UserServiceImpl;
import com.bdqn.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");  //post 解决乱码
        userService us = new UserServiceImpl();
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String address = request.getParameter("address");
        User user = new User(Integer.parseInt(id),username,password,Integer.parseInt(age),address);
        System.out.println(user);
        boolean update = us.update(user);
        System.out.println(update);
        if (update){
            //修改成功
            HttpSession session = request.getSession();
            session.setAttribute("msg", "修改成功~");
            request.getRequestDispatcher("/selectAllServlet").forward(request, response);
        }else {
            request.setAttribute("msg", "修改失败~");
            request.getRequestDispatcher("/selectAllServlet").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
