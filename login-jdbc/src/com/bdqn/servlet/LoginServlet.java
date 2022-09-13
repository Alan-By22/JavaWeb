package com.bdqn.servlet;

/*
 * @创建人   zby
 * @创建时间 2022/9/8---19:06
 * @描述信息
 */

import com.bdqn.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //查询数据库
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //获得连接
            connection = JDBCUtils.connection();

            //会有注入的风险
            /*//执行sql对象
            statement = connection.createStatement();
            //3.编写sql
            String sql = "select * from user where " + "username='" + username + "'and password='" + password + "'";
            //执行sql
            resultSet = statement.executeQuery(sql);*/

            //使用预编译sql对象
            String sql = "select * from user where username = ? and password = ?";
            preparedStatement = connection.prepareStatement(sql);
            //赋值
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            //执行
            resultSet = preparedStatement.executeQuery();

            if(resultSet .next()){
                //获得用户名
                String username1 = resultSet.getString("username");
                //存到域对象中
                req.getSession().setAttribute("msg","欢迎"+username1);
            }else {
                req.getSession().setAttribute("msg","请先登录");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection,preparedStatement,resultSet);
        }

        //响应跳转页面
        resp.sendRedirect(req.getContextPath()+"/msg.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
