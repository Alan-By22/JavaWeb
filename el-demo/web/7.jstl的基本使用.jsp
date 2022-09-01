<%--
  Created by IntelliJ IDEA.
  User: 11752
  Date: 2022/9/1
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl的基本使用</title>
</head>
<body>
<%--1.存储数据--%>
<% pageContext.setAttribute("score","C");%>
<hr>
<%--对成绩进行判断--%>
<c:if test="${score eq 'A'}">
    优秀
</c:if>
<hr>

<c:choose>
    <c:when test="${score eq 'A'}">优秀</c:when>
    <c:when test="${score eq 'B'}">良好</c:when>
    <c:when test="${score eq 'C'}">及格</c:when>
    <c:when test="${score eq 'D'}">较差</c:when>

    <c:otherwise>非法字符</c:otherwise>
</c:choose>



</body>
</html>
