package com.bdqn.dao;

/*
 * @创建人   zby
 * @创建时间 2022/9/2---12:13
 * @描述信息
 */

import com.bdqn.bean.Student;
import com.bdqn.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    //添加
    @Override
    public int saveStudent(Student student) {
        Connection connection = null;
        Statement statement = null;
        int i = 0;
        try {
            //获得连接
            connection = JDBCUtils.getConnection();
            //2.执行sql对象
            statement = connection.createStatement();
            //3.
            String sql = "insert into student values " +
                    "('" + student.getSid() + "','" + student.getName() + "'," + student.getScore() + ")";
            //4.执行
            i = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放
            JDBCUtils.close(connection, statement);
        }
        return i;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public int deleteById(String sid) {
        return 0;
    }

    @Override
    public Student findById(String sid) {
        return null;
    }

    @Override
    public int updateStu(Student student) {
        return 0;
    }
}
