<%--
  Created by IntelliJ IDEA.
  User: 11752
  Date: 2022/8/25
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生管理系统</title>
</head>
<body>
<h1>欢迎来到学生管理系统</h1>
<%--判断用户是否登陆--%>

<c:if test="${sessionScope.username eq null}">
    <a href="#{pageContext.request.contextPath}/login.jsp">请先登录</a>
</c:if>

<c:if test="${sessionScope.username ne null}">
    <a href="${pageContext.request.contextPath}/addStu.jsp">添加学生</a>
    <a href="${pageContext.request.contextPath}/findAllStuServlet">查询学生</a>
</c:if>


<%--<%--%>
<%--    Object username = session.getAttribute("username");--%>
<%--    if (username == null) {--%>
<%--%>--%>
<%--<a href="/stu/login.jsp">请先登录</a>--%>
<%--<% } else { %>--%>
<%--<a href="/stu/addStu.jsp">添加学生</a>--%>
<%--<a href="/stu/findAllStuServlet">查询学生</a>--%>
<%--<% } %>--%>
</body>
</html>
