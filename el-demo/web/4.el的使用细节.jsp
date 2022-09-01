<%@ page import="java.lang.annotation.ElementType" %><%--
  Created by IntelliJ IDEA.
  User: 11752
  Date: 2022/9/1
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用细节</title>
    <%--el的获取数据:四大域对象--%>
</head>
<body>
<%--存数据--%>
<%
    pageContext.setAttribute("username", "lisi001");
    request.setAttribute("username", "lisi001");
    session.setAttribute("username", "lisi001");
    application.setAttribute("username", "lisi001");

%>

el表达式获取数据:${username};


<%--
${username}......pageContext.findAttribute("username")
后期使用el的时候------注意域对象的范围

--%>
</body>
</html>
