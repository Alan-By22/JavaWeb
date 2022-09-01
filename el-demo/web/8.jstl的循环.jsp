<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 11752
  Date: 2022/9/1
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>循环</title>
</head>
<body>
<%
    List<String> list = new ArrayList<>();
    list.add("111");
    list.add("222");
    list.add("333");
    list.add("444");
    list.add("555");
    list.add("666");
    //将集合存入到--域对象中
    pageContext.setAttribute("list", list);
%>
<%--
<c:forEach :用来遍历集合
items="":当前你要遍历的集合是谁? ---${list}
var="": 将当前集合中的每一个元素--存到page域中 --- s
begin="": 开始的索引
end="":结束的索引
step="":控制条件
varStatus="":计数的对象--有两个属性:1.记录索引(0) 2.统计个数(1)
--%>
<c:forEach items="${list}" var="s" begin="0" end="5" step="2" varStatus="vs">
    ${s}
    <%--s是集合中的每一个对象--%>
    <%--111,333,555--%>
</c:forEach>
<hr/>

<c:forEach items="${list}" var="s">
    ${s}
</c:forEach>
<hr/>

<table border="1px">
    <tr>
        <td>索引</td>
        <td>统计个数</td>
        <td>字符串</td>
    </tr>
    <c:forEach items="${list}" var="str" varStatus="vs">
    <tr>
        <td>${vs.index}</td>
        <td>${vs.count}</td>
        <td>${str}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
