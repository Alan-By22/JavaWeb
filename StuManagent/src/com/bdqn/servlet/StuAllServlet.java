package com.bdqn.servlet;

import com.bdqn.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

@WebServlet("/findAllServlet")
public class StuAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.读取文件
        BufferedReader reader = new BufferedReader(new FileReader("D:\\stu.txt"));
        //创建集合
        ArrayList<Student> list = new ArrayList<>();
        String len;
        while ((len = reader.readLine())!=null){
            String[] split = len.split(",");
            Student student = new Student(split[0],split[1],Integer.parseInt(split[2]));
            //存入集合
            list.add(student);
        }

        //响应
        resp.setContentType("text/html; Charset=utf-8");
        PrintWriter writer = resp.getWriter();
        for (Student student : list) {
            writer.println("ID:"+student.getSid()+",姓名:"+student.getName()+",成绩:"+student.getScore());
            writer.println("<br/>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
