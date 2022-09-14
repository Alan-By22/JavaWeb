package com.bdqn.test;

/*
 * @创建人   zby
 * @创建时间 2022/9/13---17:59
 * @描述信息
 */

import com.bdqn.bean.Student;
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
public class StudentTest {

    /**
     * 5.删除
     */
    @Test
    public void deleteStu() throws Exception {
        //1.加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatisConfig.xml");
        //2.sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.sqlSession----//开启手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.执行sql
        int i = sqlSession.delete("studentMapper.delStudent", 4);
        if (i > 0) {
            System.out.println("删除成功");
        }
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        inputStream.close();

    }

    /**
     * 4.修改
     */
    @Test
    public void update() throws Exception {
        //1.加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatisConfig.xml");
        //2.sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.sqlSession----//开启手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.执行sql交
        int i = sqlSession.update("studentMapper.updateStu", new Student(4, "嘻1嘻", 26));
        if (i > 0) {
            System.out.println("修改成功");
        }
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        inputStream.close();

    }

    /**
     * 3.添加
     */
    @Test
    public void save() throws Exception {
        //加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatisConfig.xml");
        //2.sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.sqlSession----//开启手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.执行sql
        int i = sqlSession.insert("studentMapper.addStudent", new Student("妮妮1", 36));
        if (i > 0) {
            System.out.println("添加成功");
        }
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        inputStream.close();
    }

    /**
     * 2.根据id查询
     */
    @Test
    public void findOne() throws Exception {
        //加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatisConfig.xml");
        //2.sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.sqlSession----//开启手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.
        Student student = sqlSession.selectOne("studentMapper.findOne", 2);
        //5.
        System.out.println(student);
        //6.释放资源
        sqlSession.close();
        inputStream.close();

    }

    /**
     * 1.查询全部
     */
    @Test
    public void findAll() throws Exception {
        //加载配置文件---输入流
        InputStream inputStream = Resources.getResourceAsStream("mybatisConfig.xml");
        //通过构建器获得sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获得sqlSessionFactory----//开启手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //操作--查询
        List<Student> list = sqlSession.selectList("studentMapper.findAll");
        //遍历
        for (Student student : list) {
            System.out.println(student);
        }

        //释放资源
        sqlSession.close();
        inputStream.close();
    }
}
