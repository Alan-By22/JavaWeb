package com.bdqn.Test;

import com.bdqn.bean.Card;
import com.bdqn.bean.Classes;
import com.bdqn.bean.Course;
import com.bdqn.bean.Student;
import com.bdqn.mapper.ManyToManyMapper;
import com.bdqn.mapper.OneToManyMapper;
import com.bdqn.mapper.OneToOneMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 11752
 * @创建人 zby
 * @创建时间 2022/9/18---11:50
 * @描述信息
 */

public class Test01 {

    /**
     * 一对一
     */
    @Test
    public void findAll() {
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        try {
            //加载配置
            resourceAsStream = Resources.getResourceAsStream("mybatisConfig.xml");
            //获得sqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //sqlSession
            sqlSession = sqlSessionFactory.openSession(true);
            //4.
            OneToOneMapper mapper = sqlSession.getMapper(OneToOneMapper.class);
            List<Card> list = mapper.findAll();
            //5.
            for (Card card : list) {
                System.out.println(card);
            }
        } catch (Exception e) {
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
     * 一对多
     */
    @Test
    public void findAll2() {
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        try {
            //加载配置
            resourceAsStream = Resources.getResourceAsStream("mybatisConfig.xml");
            //获得sqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //sqlSession
            sqlSession = sqlSessionFactory.openSession(true);
            //4.
            OneToManyMapper mapper = sqlSession.getMapper(OneToManyMapper.class);
            List<Classes> list = mapper.findAll();
            //遍历
            for (Classes classes : list) {
                System.out.println(classes);
            }

        } catch (Exception e) {
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
     * 多对多
     */
    @Test
    public void findAll3() {
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        try {
            //加载配置
            resourceAsStream = Resources.getResourceAsStream("mybatisConfig.xml");
            //获得sqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //sqlSession
            sqlSession = sqlSessionFactory.openSession(true);
            //4.
            ManyToManyMapper mapper = sqlSession.getMapper(ManyToManyMapper.class);
            List<Student> list = mapper.findAll();
            for (Student student : list) {
                System.out.print(student+" ");
                List<Course> courses = student.getCourses();
                System.out.println(courses);
            }

        } catch (Exception e) {
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
