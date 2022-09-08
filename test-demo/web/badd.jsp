<%--
  Created by IntelliJ IDEA.
  User: 小菜鸡
  Date: 2022/8/9
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%--引入jstl标签--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>信息添加</title>

    <style>
        .d1{
            width: 400px;
            height: 400px;
            border-radius: 90% 0%;
            background-color: aquamarine;
            margin: auto;
        }
        .t1{
            margin: auto;
            padding: 20px;
            text-align: center;
            line-height: 30px;
            position: relative;
            top: 60px;
        }


    </style>
</head>
<body>
<div>

    <div class="d1">
        <form action="${pageContext.request.contextPath}/addServlet" method="POST">


            <table cellspacing="0px" class="t1">
                <tr>
                    <td colspan="2"> <h3>信息添加</h3> </td>
                </tr>
                <tr>
                    <td>账号</td>

                    <td>  <input type="text" name="username"  /> </td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td>  <input type="text" name="password"  /> </td>
                </tr>
                <tr>
                    <td>年龄 </td>
                    <td> <input type="text" name="age" /> </td>
                </tr>
                <tr>
                    <td>地址 </td>
                    <td> <input type="" name="address"  /> </td>
                </tr>


                <tr>
                    <td><input type="submit" value="提交"></td>
                    <td><input type="reset" value="清除"></td>
                </tr>
            </table>
        </form>

    </div>


</div>



</body>

</html>
