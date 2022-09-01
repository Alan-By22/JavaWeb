<%--
  Created by IntelliJ IDEA.
  User: 11752
  Date: 2022/8/31
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>el的入门</title>
    <%-- el的作用:在jsp页面获取数据,问题:从哪儿块获取数据
     1.四个域对象---获取数据---从小到大(域对象的范围)的获取---有就返回数据--没有就没有
     pageContext  页面域
     request  请求域
     session  会话域
     servletContext  应用域 (jsp的九个内置对象:application)
     --%>
  </head>
  <body>
  添加数据<% pageContext.setAttribute("name","lisi");%>
  <hr/>
  1.使用java的方式获取数据
  <% Object name = pageContext.getAttribute("name");
  out.println(name);
  %>
  <hr/>
  2.jsp标签的方式获取数据
  <%=pageContext.getAttribute("name")%>
  <hr/>
  3.el表达式获取数据
  ${name}
  <hr/>
  </body>
</html>
