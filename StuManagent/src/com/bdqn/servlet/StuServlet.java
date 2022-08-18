package com.bdqn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//学生的servlet
@WebServlet("/addServlet")
public class StuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收
        req.setCharacterEncoding("utf-8");
        String sid = req.getParameter("sid");
        String name = req.getParameter("name");
        String score = req.getParameter("score");
        //2.获取前台的验证码
        String checkcode = req.getParameter("checkcode");
        System.out.println("前台输入的:-------"+checkcode);
        //3.获取我们生成的验证码
        String code = (String) getServletContext().getAttribute("code");
        System.out.println("自己生成输入的:-------"+code);
        //保存--数据库--本地磁盘的文件
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter("D:\\stu.txt",true));
        //写
        fileWriter.write(sid+","+name+","+score);
        //换行
        fileWriter.newLine();
        fileWriter.close();

        //相应
//        PrintWriter writer = resp.getWriter();
//        writer.println("Added successfully!!");
//        writer.close();
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("添加成功!5秒后跳转到首页");
        //跳转
        resp.setHeader("Refresh","5,URL=/index.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
