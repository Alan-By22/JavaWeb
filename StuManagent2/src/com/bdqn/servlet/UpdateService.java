package com.bdqn.servlet;

import com.bdqn.bean.Student;
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
 * @创建人 zby
 * @创建时间 2022/9/20---16:28
 * @描述信息
 */

@WebServlet("/updateStu")
public class UpdateService extends HttpServlet {
    /**
     * 注入service
     */
    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收
        req.setCharacterEncoding("utf-8");
        String sid = req.getParameter("sid");
        String name = req.getParameter("name");
        String score = req.getParameter("score");
        //数据的封装
        Student student = new Student(sid, name, Integer.parseInt(score));
        //2.修改----service
        int result = studentService.updateStu(student);
        HttpSession session = req.getSession();
        //3.
        if (result > 0) {
            //成功
            session.setAttribute("code", "修改成功!200");
            resp.sendRedirect(req.getContextPath() + "/findAllStuServlet");
        } else {
            //失败
            session.setAttribute("code", "修改失败!500");
            //页面
            resp.sendRedirect(req.getContextPath() + "/error.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
