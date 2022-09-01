<%@ page import="com.bdqn.bean.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 11752
  Date: 2022/9/1
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>运算符</title>
</head>
<body>
<%--关系运算符和逻辑运算符与java中的使用方法一致--%>
${1>2 || 1<6}---true
${1>2 && 6>3}---false

<%--2.为空的校验 empty
1.对象是否为空,2.字符串3.集合
--%>
<hr>
<%
    User user = null;
    String str = "65656";
    List list = new ArrayList<>();

    //添加到域对象中
    pageContext.setAttribute("user", user);
    pageContext.setAttribute("str", str);
    pageContext.setAttribute("list", list);
%>
el判断对象是否为空:${empty user} <br/>
el判断字符串是否为空:${empty str}<br/>
el判断集合中的元素个数:${empty list}<br/>
<hr>


<%--用于数据的回显--%>
<%
    //存储设备---使用三元运算符
    pageContext.setAttribute("sex", "woman");
%>

男<input type="radio" name="sex" value="man" ${sex eq "man" ? "checked":""}>
女<input type="radio" name="sex" value="woman" ${sex eq "woman" ? "checked":""}>

</body>
</html>
