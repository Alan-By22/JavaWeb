
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%--引入jstl标签--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>信息管理</title>

    <style>
        .head {
            width: 100%;
            height: 35px;
            background-color: antiquewhite;
            text-align: center;
        }

        .table {
            position: relative;
            top: 50px;
            margin: auto;
            text-align: center;
            width: 800px;
            border: 1px solid;


        }
        .sp1{
            display: block;
            float: left;
            position: relative;
            top: 15px;
            left: 50px;
        }

        td {
            border: 1px solid;
        }
        .lift{
            font-size: 25px;
        }
        .bt{
            position: relative;
            left: -320px;
            top: 38px;
            padding: 5px;
            background-color: blanchedalmond;
            box-shadow: 0 0  0 1px;
            color: black;


        }
    </style>
</head>
<body>
<div>
    <div class="head">   <span>   <a href="${pageContext.request.contextPath}/badd.jsp" class="bt"> 添加数据 </a>  </span>     <span class="lift">0o0</span>
        <span class="sp1"> ${msg}  </span> ${msg}   </div>

    <div class="tab">
        <form action="${pageContext.request.contextPath}/selectAllServlet" method="POST">
            <table class="table" cellspacing="0px">
                <tr>
                    <td colspan="7">
                        商品管理
                    </td>
                </tr>
                <tr>
                    <td>序号</td>
                    <td>账号</td>
                    <td>密码</td>
                    <td>年龄</td>
                    <td>地址</td>

                    <td>设置</td>
                </tr>
<%--                            "${userAll}"  域 传过来的名称  var="brand"  别名      varStatus="start"  排序                                 --%>
                <c:forEach items="${userAll}" var="brand" varStatus="start" >
                    <tr>
                        <td>${start.count}</td>
                        <td>${brand.username}</td>
                        <td>${brand.password}</td>
                        <td>${brand.age}</td>
                        <td>${brand.address}</td>

                        <td><a href="${pageContext.request.contextPath}/findidServlet?id=${brand.id}">修改</a> <a href="${pageContext.request.contextPath}/delServlet?id=${brand.id}">删除</a>     </td>
                    </tr>
                </c:forEach>

            </table>


        </form>

    </div>

</div>



</body>

</html>

