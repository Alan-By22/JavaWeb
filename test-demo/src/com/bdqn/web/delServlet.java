package com.bdqn.web;

import com.bdqn.service.UserServiceImpl;
import com.bdqn.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/delServlet")
public class delServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");  //post 解决乱码
        String id = request.getParameter("id");
        userService us = new UserServiceImpl();
        boolean b = us.delUser(Integer.parseInt(id));

        if (b){
            //删除成功
            HttpSession session = request.getSession();
            session.setAttribute("msg", "删除成功~");
            // 重新查新全部  简称刷新
            request.getRequestDispatcher("/selectAllServlet").forward(request, response);
        }else {
            //删除失败
            request.setAttribute("msg", "删除失败~");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
