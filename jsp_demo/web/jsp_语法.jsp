<%--
  Created by IntelliJ IDEA.
  User: 11752
  Date: 2022/8/24
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp的语法</title>
</head>
<body>
<%--1.jsp的注释  ctrl+shift+/--%>
<%--2.java的代码
注意:里面写的代码---servlet---_jspService---局部变量
--%>
<%--局部变量--%>
<%
    int a = 10;
    out.println("a=" + a);
%>
<hr>
<%--3.jsp的表达式--%>
<%=a%>
<%="哈哈"%>
<% out.println("嘿嘿");%>
<hr>
<%--4.jsp的声明--  变量--方法--静态方法--成员变量
--%>
<%! String name = "李四";  %>

<%--带!是成员变量,不带是局部变量--就近原则--%>
<% String name = "李四";  %>
<%= name%>
<hr>

<%--方法--%>
<%!
    public void sum(){

    }
%>
</body>
</html>
