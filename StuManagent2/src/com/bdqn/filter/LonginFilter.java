package com.bdqn.filter;

/*
 * @创建人   zby
 * @创建时间 2022/9/4---13:21
 * @描述信息
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*检查登陆处理*/
@WebFilter(value = {"/addStu.jsp", "/findAllStuServlet"})
public class LonginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.转换成我们的http请求的Request,Response
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //2.因为登陆成功后,将用户的信息会保存到session域中--判断session中是否存在用户的信息
        //存在--放行--不存在--跳转到登录的页面
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");
        //判断
        if (username == null || "".equals(username)) {
            //没有登陆
            session.setAttribute("msg", "请先登陆");
            //request.getContextPath()动态编码 -----/stu
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
        //放行
        filterChain.doFilter(request, response);
    }
}
