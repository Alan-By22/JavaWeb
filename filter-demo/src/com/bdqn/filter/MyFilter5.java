package com.bdqn.filter;

/*
 * @创建人   zby
 * @创建时间 2022/9/1---19:11
 * @描述信息
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//生命周期
/*
初始化: 应用加载的时候--过滤器就会初始化
运行: 请求的时候
销毁: 去掉应用或者服务器断掉的时候
 */
@WebFilter("/servlet666")
public class MyFilter5 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter5初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter5...正在运行");
        servletResponse.setContentType("text/html;charset=utf-8");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
        System.out.println("filter5---销毁了");
    }
}
