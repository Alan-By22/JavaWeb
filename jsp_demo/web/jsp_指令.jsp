<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 11752
  Date: 2022/8/24
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="/error.jsp" %>
<html>
<head>
    <title>jsp的指令</title>
</head>
<body>
<%
    ArrayList<String> arrayList = new ArrayList<>();
    out.println(10/0);
%>
</body>
</html>
