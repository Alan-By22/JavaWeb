<%--
  Created by IntelliJ IDEA.
  User: 11752
  Date: 2022/9/1
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el的注意事项</title>
</head>
<body>
<% //存数据
pageContext.setAttribute("str",null);
int[] arr = {1,59,6,3,1};
pageContext.setAttribute("arr",arr);
%>
1.el表达式没有空指针:${str};<br/>
2.el表达式没有索引越界:${arr[9]};<br/>
3.el表达式没有字符串的拼接:${arr[1]}+${arr[3]};

</body>
</html>
