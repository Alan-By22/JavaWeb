<%--
  Created by IntelliJ IDEA.
  User: 11752
  Date: 2022/8/17
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/reServlet3" method="post">
姓名:<input type="text" name="name"/><br/>
年龄:<input type="text" name="age"/><br/>
    <input type="radio" name="sex" value="M"/>男
    <input type="radio" name="sex" value="W"/>女<br/>
爱好:<br/>
    java<input type="checkbox" name="hobby" value="java"/>
    python<input type="checkbox" name="hobby" value="python"/>
    js<input type="checkbox" name="hobby" value="js"/><br/>
    <input type="submit" value="提交">
  </form>
  </body>
</html>
