package com.bdqn.filter;

/*
 * @创建人   zby
 * @创建时间 2022/9/1---19:11
 * @描述信息
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*filter的拦截行为*/
@WebFilter("/*")
public class MyFilter7 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //过滤规则
        System.out.println("filter7---!!!!");

        servletResponse.setContentType("text/html;charset=utf-8");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
        //请求资源的放行,如果有多个过滤器--每一个符合的过滤器执行完--请求的资源--还会回来继续执行放行方法后边的代码

        System.out.println("filter7---回来了");
    }
}

