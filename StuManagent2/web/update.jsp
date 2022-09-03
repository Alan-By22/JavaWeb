<%--
  Created by IntelliJ IDEA.
  User: 11752
  Date: 2022/9/2
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生的修改页面</title>
</head>
<body>
<h2>学生的修改页面</h2>
<form action="${pageContext.request.contextPath}/updateStu" method="post">

    <input type="hidden" name="sid" value="${stu.sid}"><br/>
    姓名:<input type="text" name="name" value="${stu.name}"><br/>
    成绩:<input type="number" name="score" value="${stu.score}"><br/>
    <input type="submit" value="修改">
</form>
</body>
</html>
