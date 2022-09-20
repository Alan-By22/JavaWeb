package com.bdqn.servlet;

/*
 * @创建人   zby
 * @创建时间 2022/9/2---15:43
 * @描述信息
 */

import com.bdqn.service.StudentService;
import com.bdqn.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 11752
 */
@WebServlet("/deleteById")
public class DeleteService extends HttpServlet {

    private StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收ID
        String sid = req.getParameter("sid");
        //根据id修改数据
        int i = studentService.deleteById(sid);
        //判断
        HttpSession session = req.getSession();
        if(i > 0){
            //成功
            session.setAttribute("code", "删除成功!");
            resp.sendRedirect(req.getContextPath()+"/findAllStuServlet");
        }else{
            //失败
            session.setAttribute("code","删除失败");
            //页面
            resp.sendRedirect(req.getContextPath()+"/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
