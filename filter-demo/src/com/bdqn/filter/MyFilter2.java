package com.bdqn.filter;

/*
 * @创建人   zby
 * @创建时间 2022/9/1---19:11
 * @描述信息
 */

import javax.servlet.*;
import java.io.IOException;

//自定义的过滤器
public class MyFilter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取过滤器的名称
        String filterName = filterConfig.getFilterName();
        System.out.println("filterName"+filterName);
        //获得初始化的参数
        String name = filterConfig.getInitParameter("name");
        System.out.println(name);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}
