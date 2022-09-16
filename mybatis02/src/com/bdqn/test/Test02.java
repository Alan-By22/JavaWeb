package com.bdqn.test;

/*
 * @创建人   zby
 * @创建时间 2022/9/15---17:35
 * @描述信息
 */

import com.bdqn.bean.Student;
import com.bdqn.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 11752
 */
public class Test02 {
    /**
     * 遍历
     * SELECT * FROM student  WHERE id IN (1,2,5)。
     * 动态查询---foreach
     */
    @Test
    public void DySelectForeach() {
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        try {
            //1.加载配置
            resourceAsStream = Resources.getResourceAsStream("mybatisConfig.xml");
            //2.获得sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.
            sqlSession = sqlSessionFactory.openSession(true);
            //4.mapper代理的方法------获得代理对象
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            //5.
            List<Integer> list = new ArrayList<>();
            list.add(3);
            list.add(5);
            list.add(6);
            list.add(8);
            List<Student> list1 = mapper.dyFindForeach(list);
            //
            list1.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 动态查询---if
     */
    @Test
    public void DySelect() {
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        try {
            //1.加载配置
            resourceAsStream = Resources.getResourceAsStream("mybatisConfig.xml");
            //2.获得sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.
            sqlSession = sqlSessionFactory.openSession(true);
            //4.mapper代理的方法
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            //5.
            Student student = new Student();
            //student.setId(5);
            student.setName("李四");
            student.setAge(28);
            List<Student> list = mapper.dyfindAll(student);
            //
            list.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
