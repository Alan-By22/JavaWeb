package com.bdqn.filter;

/*
 * @创建人   zby
 * @创建时间 2022/9/4---13:29
 * @描述信息
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 全局的乱码处理*/
@WebFilter("/*")
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //处理乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset = utf-8");

        //放行
        filterChain.doFilter(request, response);
    }
}
