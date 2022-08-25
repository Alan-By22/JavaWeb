package com.bdqn.servlet;

/*
 * @创建人   zby
 * @创建时间 2022/8/25---20:48
 * @描述信息
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@WebServlet("/addStuServlet")
public class AddStuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收
        req.setCharacterEncoding("utf-8");
        String sid = req.getParameter("sid");
        String name = req.getParameter("name");
        String score = req.getParameter("score");
        //保存--数据库--本地磁盘的文件
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\stu.txt",true));
        //写
        bufferedWriter.write(sid+","+name+","+score);
        //换行
        bufferedWriter.newLine();
        bufferedWriter.close();
        //2.添加成功
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("添加成功,2秒后跳转到首页");
        resp.setHeader("Refresh","2;URL=/stu/index.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
