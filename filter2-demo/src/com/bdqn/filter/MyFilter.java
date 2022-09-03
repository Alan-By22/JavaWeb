package com.bdqn.filter;

/*
 * @创建人   zby
 * @创建时间 2022/9/2---22:46
 * @描述信息
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value = "/index.jsp",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})//转发和请求
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //
        System.out.println("myFilter执行了.....");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
