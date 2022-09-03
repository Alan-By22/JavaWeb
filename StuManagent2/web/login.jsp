<%--
  Created by IntelliJ IDEA.
  User: 11752
  Date: 2022/8/25
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/loginServlet" method="get">
    用户名:<input type="text" name="username"><br/>
    密&nbsp;&nbsp;&nbsp;码:<input type="password" name="password"><br/>
    <input type="submit" value="登陆">
</form>
</body>
</html>
