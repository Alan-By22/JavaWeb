package com.bdqn.mapper;

/*
 * @创建人   zby
 * @创建时间 2022/9/14---17:29
 * @描述信息
 */

import com.bdqn.bean.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 11752
 */

/**
 * 数据持久层
 */
public class StudentMapperImpl implements StudentMapper {

    /**
     * 查询所有
     */
    @Override
    public List<Student> findAll() {
        InputStream resourceAsStream = null;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        List<Student> list = null;
        try {
            //1.
            resourceAsStream = Resources.getResourceAsStream("mybatisConfig.xml");
            //2.
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.
            sqlSession = sqlSessionFactory.openSession();
            //4.
            list = sqlSession.selectList("studentMapper.findAll");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
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
        return list;
    }

    @Override
    public List<Student> findNameLike(String name) {
        InputStream resourceAsStream = null;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        List<Student> list = null;
        try {
            //1.
            resourceAsStream = Resources.getResourceAsStream("mybatisConfig.xml");
            //2.
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.
            sqlSession = sqlSessionFactory.openSession();
            //4.
            list = sqlSession.selectList("studentMapper.findAllLike",name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
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
        return list;
    }
}
