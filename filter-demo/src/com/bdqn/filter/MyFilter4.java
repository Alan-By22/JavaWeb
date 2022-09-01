package com.bdqn.filter;

/*
 * @创建人   zby
 * @创建时间 2022/9/1---19:11
 * @描述信息
 */

import javax.servlet.*;
import java.io.IOException;

//自定义的过滤器
public class MyFilter4 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter4...");
        servletResponse.setContentType("text/html;charset=utf-8");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("filter4---回来了");
    }
}
