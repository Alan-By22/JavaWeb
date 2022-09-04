package com.bdqn.listener;

/*
 * @创建人   zby
 * @创建时间 2022/9/3---14:09
 * @描述信息
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/*
ServletContext
创建时机: 应用加载的时候
销毁: 服务器关闭的时候,去除应用的时候
 */

@WebListener
public class MyContextListener implements ServletContextListener {
    //监听器对象的创建方法
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //1.
        System.out.println("ServletContext创建了...");
        //2.获取
        ServletContext servletContext = sce.getServletContext();
        //System.out.println(servletContext);
        //添加
        servletContext.setAttribute("name","lisi");
        //替换
        servletContext.setAttribute("name","wangwu");
        //移除
        servletContext.removeAttribute("name");
    }

    //域对象的销毁就会执行该方法
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        //1.
        System.out.println("ServletContext销毁了------");
    }
}
