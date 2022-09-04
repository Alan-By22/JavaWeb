package com.bdqn.listener;

/*
 * @创建人   zby
 * @创建时间 2022/9/3---14:42
 * @描述信息
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//该类监听器--监听的是域对象中属性的变化
@WebListener
public class MyContextAttributeListener implements ServletContextAttributeListener {
    //监听器的添加
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("servletContext对象添加属性------");
        String name = scae.getName();
        Object value = scae.getValue();
        System.out.println(name+"----"+value);
    }

    //监听器的移除
    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("监听器检测到移除-----");
        ServletContext servletContext = scae.getServletContext();
        Object value = servletContext.getAttribute("name");
        System.out.println(value);
    }

    //监听器的替换
    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("监听器检测到替换------");
        ServletContext servletContext = scae.getServletContext();
        Object value = servletContext.getAttribute("name");
        System.out.println(value);
    }
}
