package com.bdqn.test;

/*
 * @创建人   zby
 * @创建时间 2022/9/15---15:52
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
import java.util.List;

/**
 * @author 11752
 */
public class Test01 {
    /**
     * 删除
     */
    @Test
    public void deleteById() {
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
            Integer integer = mapper.deleteStuById(7);
            if (integer > 0) {
                System.out.println("删除成功");
            }

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
     * 修改
     */
    @Test
    public void update() {
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
            mapper.upDataStu(new Student(6, "妮妮2", 26));

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
     * 添加
     */
    @Test
    public void insert() {
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
            Integer integer = mapper.insertStu(new Student("李四12", 29));
            if (integer > 0) {
                System.out.println("添加成功");
            }

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
     * 根据id查询
     */
    @Test
    public void findById() {
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
            Student student = mapper.findStudentById(2);
            System.out.println(student);

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
     * 查询所有
     */
    @Test
    public void findAll() {
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
            List<Student> list = mapper.findAll();
            //6.遍历
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
