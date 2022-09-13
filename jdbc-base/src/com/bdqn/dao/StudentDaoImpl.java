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
import java.util.Properties;


//数据持久层--数据库
public class StudentDaoImpl implements StudentDao {
    //查询全部
    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //2.获得连接
            connection = JDBCUtils.connection();
            //使用statement会有风险的注入
//            //获得执行的sql的对象
//            statement = connection.createStatement();
//            //执行sql
//            resultSet = statement.executeQuery("select * from student");
            preparedStatement = connection.prepareStatement("select * from student");
            resultSet = preparedStatement.executeQuery();
            //封装---遍历
            while (resultSet.next()) {
//                //获得数据
//                int sid = resultSet.getInt("sid");
//                String name = resultSet.getString("name");
//                int age = resultSet.getInt("age");
//                Date birthday = resultSet.getDate("birthday");
                //封装
                Student student = new Student();
                student.setSid(resultSet.getInt("sid"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setBirthday(resultSet.getDate("birthday"));
                //添加到集合中
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
        return studentList;
    }

    //2.id查询
    @Override
    public Student findById(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student student = null;
        try {
            //获得连接
            connection = JDBCUtils.connection();
//            //获得执行sql的对象
//            statement = connection.createStatement();
//            //执行sql
//            resultSet = statement.executeQuery("select * from student where sid = "+id);
            preparedStatement = connection.prepareStatement("select * from student where sid = ?");
            preparedStatement.setInt(1, id);
            //执行
            resultSet = preparedStatement.executeQuery();
            //遍历
            while (resultSet.next()) {
//                //获得数据
//                int sid = resultSet.getInt("sid");
//                String name = resultSet.getString("name");
//                int age = resultSet.getInt("age");
//                Date birthday = resultSet.getDate("birthday");
                //封装
                student = new Student();
                student.setSid(resultSet.getInt("sid"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setBirthday(resultSet.getDate("birthday"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
        return student;
    }

    //添加学生
    @Override
    public int saveStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            //2.获得连接
            connection = JDBCUtils.connection();
//            //3.获得执行sql的对象
//            statement = connection.createStatement();
//            //执行sql
//            String sql = "insert into " + "student values (null,'" + student.getName() + "'," + student.getAge() + ",'" + student.getBirthday() + "')";
            //获取对象
            preparedStatement = connection.prepareStatement("insert into student(sid,name,age,birthday)values (null,?,?,?)");
            //设置参数
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setDate(3, new Date(student.getBirthday().getTime()));
            //执行sql
            i = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement);
        }

        return i;
    }

    //修改学生
    @Override
    public int updateStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            //2.
            connection = JDBCUtils.connection();
//            //3.获得执行sql的对象
//            statement = connection.createStatement();
//            //执行sql
//            String sql = "update student set name = " +
//                    "'" + student.getName() + "',age=" + student.getAge() +
//                    ",birthday='" + student.getBirthday() + "' where sid = " + student.getSid();
//            i = statement.executeUpdate(sql);
            //获取对象
            preparedStatement = connection.prepareStatement("update student set name = ?,age = ?,birthday = ?where sid = ?");
            //设置参数
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setDate(3, new Date(student.getBirthday().getTime()));
            preparedStatement.setInt(4, student.getSid());
            //执行
            i = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement);
        }
        return i;
    }

    //删除学生
    @Override
    public int deleteStudentById(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            //2.
            connection = JDBCUtils.connection();
//            //3.获得执行sql的对象
//            statement = connection.createStatement();
//            //执行sql
//            String sql = "delete  from student where sid = " + id;
//            i = statement.executeUpdate(sql);
            //获得对象
            preparedStatement = connection.prepareStatement("delete from student where sid = ?");

            // preparedStatement = connection.prepareStatement("alter table student auto_increment = ?");
            //设置参数
            preparedStatement.setInt(1, id);
            //执行sql
            i = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement);
        }
        return i;
    }
}
