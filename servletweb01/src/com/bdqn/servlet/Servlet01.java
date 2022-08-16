package com.bdqn.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

//1.导包--两个包
//2.编写类--继承
//3.重写service方法
//4.在web.xml配置映射关系
//5.将当前的工程添加到tomcat中
//6.启动--访问
public class Servlet01 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("方法运行了");
    }
}
