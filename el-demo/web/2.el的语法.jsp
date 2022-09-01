<%@ page import="com.bdqn.bean.User" %>
<%@ page import="com.bdqn.bean.Car" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 11752
  Date: 2022/8/31
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el的语法</title>
</head>
<body>
<%--1.获取普通的数据--%>
<% request.setAttribute("num", "10");%>
el获取基本的语法:${num}
<hr/>
<%--2.获取自定义的对象
el: ${属性.属性}
--%>
<% request.setAttribute("user", new User("李四", 23, new Car("奔驰", "玫瑰金")));%>
el获取自定义对象:${user}<br>
el获取自定义对象的属性1:${user.toString()}<br>
el获取自定义对象的属性2:${user.age}<br>
el获取自定义对象的属性3:${user.car}<br>
el获取自定义对象的属性的属性:${user.car.brand}<br>
<hr>
<%--3.获取数组--%>
<% String[] arr = {"a", "v", "r", "g", "h"};
    request.setAttribute("arr", arr);
%>
el获取数组的元素:${arr}<br>
el获取数组的元素-索引:${arr[0]}<br>
el获取数组的元素-索引:${arr[3]}<br>
<hr>
<%--4.获取list集合--%>
<% List<String> list = new ArrayList<>();
    list.add("qwe");
    list.add("rtr");
    list.add("tyye");
    list.add("wddf");
    request.setAttribute("list", list);
%>
el获取list集合中的数据:${list}<br>
el获取list集合中的数据-索引:${list[1]}<br>
el获取list集合中的数据-get:${list.get(1)}
<hr>
<%--5.获取map集合--%>
<% Map<String, User> map = new HashMap<>();
    map.put("001", new User("李四", 23, new Car("吉利", "黑色")));
    map.put("aaa", new User("王五", 22, new Car("奇瑞", "白色")));
//存储到四大域对象中(其一)
    request.setAttribute("map", map);
%>
el获取map集合中的数据:${map}<br>
el获取map集合中的数据-属性:${map.aaa}<br>
el获取map集合中的数据-属性:${map["001"]}<br>
el获取map集合中的数据-属性的属性:${map.aaa.car}<br>
el获取map集合中的数据-属性的属性:${map.aaa.car.brand}<br>


<hr/>
</body>
</html>
