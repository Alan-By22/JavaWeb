package com.bdqn.servlet;

import com.bdqn.bean.Student;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/reServlet3")
public class RequestDemo3 extends HttpServlet {
    /*
 1.String  getParameter(String var1);  :根据名字获得对应的值
 2.Enumeration<String>  getParameterNames(); 获得参数的所有名字
 3.String[] getParameterValues(String var1);获得多个值
 4.Map<String, String[]> getParameterMap();获得参数名以及对应的值得map集合
      */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //getParamet1(req);

        //parameter2(req);

        //getParameterMap3(req);

        //student1(req);

        //4.在Servlet中获取以及封装的过程--过于繁琐---解决?
        //获取数据的map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        //获得对象
        Student student = new Student();
        //封装
        try {
            //第三方的工具类--反射的时候--实现过底层
            BeanUtils.populate(student,parameterMap);
            System.out.println(student);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void student1(HttpServletRequest req) {
        //获取封装
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String[] hobbies = req.getParameterValues("hobby");
        //2.
        Student student = new Student(name, sex, Integer.parseInt(age), hobbies);
        //3.
        System.out.println(student);
    }

    private void getParameterMap3(HttpServletRequest req) {
        Map<String, String[]> map = req.getParameterMap();
        Set<String> set = map.keySet();
        for (String name : set) {
            //根据name---value
            String[] strings = map.get(name);
            System.out.println(name+"---"+ Arrays.toString(strings));
        }
    }

    private void parameter2(HttpServletRequest req) {
        //2.Enumeration<String> getParameterNames(); 获得参数的所有名字
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            //获得名字
            String name = parameterNames.nextElement();
            //值
            String[] parameterValues = req.getParameterValues(name);
            //输出
            System.out.println(name + "---" + Arrays.toString(parameterValues));
        }
    }

    private void getParamet1(HttpServletRequest req) {
        //1.String  getParameter(String var1);  :根据名字获得对应的值
        String name = req.getParameter("name");
        System.out.println("name:" + name);
        String age = req.getParameter("age");
        System.out.println("age:" + age);
        String six = req.getParameter("six");
        if ("M".equals(six)) {
            System.out.println("six:男");
        } else {
            System.out.println("six:女");

        }
        //2.爱好 String[] getParameterValues(String var1);获得多个值
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println("hobby:" + Arrays.toString(hobbies));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
