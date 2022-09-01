<%--
  Created by IntelliJ IDEA.
  User: 11752
  Date: 2022/9/1
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el的11个内置对象</title>
</head>
<body>
<%-- 1.四大域对象--%>
<%--
PageContext Javax.serlvet.jsp.PageContext PageContext 完全一样
ApplicationScope Java.util.Map 没有 应用层范围
SessionScope Java.util.Map 没有 会话范围
RequestScope Java.util.Map 没有 请求范围
PageScope Java.util.Map 没有 页面层范围
--%>

1.pageContext作用:为了让我们获取另外的八大内置对象<br/>
<%--
获取资源的绝对路径<% application.getRealPath("/a.txt");%>
--%>
获取项目的虚拟目录jsp:<%= request.getContextPath()%><br/>
获取项目的虚拟目录el:${pageContext.request.contextPath};<%--属性.属性的方法--%>
<hr>

2.四大域对象<% session.setAttribute("username", "name");%>
${sessionScope.username}<br/>
${username}
<hr>

3.请求头:
<%--Header Java.util.Map 没有 请求消息头key，值是
value（一个）
HeaderValues Java.util.Map 没有
请求消息头key，值是
数组（一个头多个
值）--%>
<br>
请求头:${header.Connection}<br/>
请求头--多个值:${headerValues.Connection[0]}<br>
<hr>

4.传递的参数(请求参数)
<br/><%--
Param Java.util.Map 没有 请求参数key，值是
value（一个）
ParamValues Java.util.Map 没有
请求参数key，值是数
组（一个名称多个
值）
--%>
<%--地址栏http://localhost/el/6.el%E7%9A%8411%E4%B8%AA%E5%86%85%E7%BD%AE%E5%AF%B9%E8%B1%A1.jsp?username=lisi&hobby=java&hobby=js&hobby=servlet--%>
传递的参数:${param.username}<br>
传递的参数--多个值:${paramValues.hobby}<br>
传递的参数--多个值:${paramValues.hobby[0]}<br>
传递的参数--多个值:${paramValues.hobby[1]}<br>
<hr/>

5.全局的初始参数
<br/>
<%--InitParam  Java.util.Map
--%>
获取全局的参数:${initParam.address}
<hr/>

6.cookie
获得cookie:${cookie}<br/>
获得cookie:${cookie.JSESSIONID}<br/>
获得cookie:${cookie.JSESSIONID.name}<br/>
获得cookie:${cookie.JSESSIONID.value}<br/>

</body>
</html>
