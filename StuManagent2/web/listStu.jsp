<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11752
  Date: 2022/8/25
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示的页面</title>
    <style>
        table {
            width: 600px;
            text-align: center;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<h2>学生信息展示</h2>
<table border="1px">
    <tr>
        <th>序号</th>
        <th>学号</th>
        <th>姓名</th>
        <th>成绩</th>
        <th>修改||删除</th>
    </tr>
    <c:forEach items="${students}" var="stu" varStatus="vs">
        <tr>
            <th>${vs.count}</th>
            <th>${stu.sid}</th>
            <th>${stu.name}</th>
            <th>${stu.score}</th>
            <th><a href="${pageContext.request.contextPath}">修改</a></th>
        </tr>
    </c:forEach>







<%--    <%--%>
<%--        //从域对象中session取值--%>
<%--        ArrayList<Student> students = (ArrayList<Student>) session.getAttribute("students");--%>
<%--        //遍历--%>
<%--        for (Student student : students) {--%>

<%--    %>--%>
<%--    <tr>--%>
<%--        <td><%=student.getSid()%>--%>
<%--        </td>--%>
<%--        <td><%=student.getName()%>--%>
<%--        </td>--%>
<%--        <td><%=student.getScore()%>--%>
<%--        </td>--%>
<%--    </tr>--%>

<%--    <%--%>
<%--        }--%>
<%--    %>--%>
</table>
</body>
</html>
