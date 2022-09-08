package com.bdqn.dao;

/*
 * @创建人   zby
 * @创建时间 2022/9/7---17:04
 * @描述信息
 */

import com.bdqn.domain.Student;
import com.bdqn.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//数据持久层--数据库
public class StudentDaoImpl implements StudentDao {
    //查询全部
    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //2.获得连接
            connection = JDBCUtils.connection();
            //获得执行的sql的对象
            statement = connection.createStatement();
            //执行sql
            resultSet = statement.executeQuery("select * from student");
            //封装---遍历
            while (resultSet.next()) {
                //获得数据
                int sid = resultSet.getInt("sid");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Date birthday = resultSet.getDate("birthday");
                //封装
                Student student = new Student(sid, name, age, birthday);
                //添加到集合中
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtils.close(connection, statement, resultSet);
        }
        return studentList;
    }

    //2.id查询
    @Override
    public Student findById(Integer id) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Student student = null;
        try {
            //获得连接
            connection = JDBCUtils.connection();
            //获得执行sql的对象
            statement = connection.createStatement();
            //执行sql
            resultSet = statement.executeQuery("select * from student where sid =" + id);
            //遍历
            while (resultSet.next()) {
                //获得数据
                int sid = resultSet.getInt("sid");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Date birthday = resultSet.getDate("birthday");
                //封装
                student = new Student(sid, name, age, birthday);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtils.close(connection, statement, resultSet);
        }
        return student;
    }

    //添加学生
    @Override
    public int saveStudent(Student student) {
        Connection connection = null;
        Statement statement = null;
        int i = 0;
        try {
            //2.获得连接
            connection = JDBCUtils.connection();
            //3.获得执行sql的对象
            statement = connection.createStatement();
            //执行sql
            String sql = "insert into " + "student values (null,'" + student.getName() + "'," + student.getAge() + ",'" + student.getBirthday() + "')";
            i = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement);
        }

        return i;
    }

    //修改学生
    @Override
    public int updateStudent(Student student) {
        Connection connection = null;
        Statement statement = null;
        int i = 0;
        try {
            //2.
            connection = JDBCUtils.connection();
            //3.获得执行sql的对象
            statement = connection.createStatement();
            //执行sql
            String sql = "update student set name = " +
                    "'" + student.getName() + "',age=" + student.getAge() +
                    ",birthday='" + student.getBirthday() + "' where sid = " + student.getSid();
            i = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement);
        }
        return i;
    }

    //删除学生
    @Override
    public int deleteStudentById(Integer id) {
        Connection connection = null;
        Statement statement = null;
        int i = 0;
        try {
            //2.
            connection = JDBCUtils.connection();
            //3.获得执行sql的对象
            statement = connection.createStatement();
            //执行sql
            String sql = "delete  from student where sid = " + id;
            i = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement);
        }
        return i;
    }
}
