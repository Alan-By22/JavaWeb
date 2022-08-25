<%--
  Created by IntelliJ IDEA.
  User: 11752
  Date: 2022/8/25
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生添加页面</title>
</head>
<body>
<h2>学生添加页面</h2>
<form action="/stu/addStuServlet" method="post">
    学号:<input type="number" name="sid"><br/>
    姓名:<input type="text" name="name"><br/>
    年龄:<input type="number" name="score"><br/>
    <input type="submit" value="添加">
</form>
</body>
</html>
