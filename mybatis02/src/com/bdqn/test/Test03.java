package com.bdqn.test;

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
 * @创建人 zby
 * @创建时间 2022/9/16---16:32
 * @描述信息
 */

public class Test03 {
    @Test
    public void findAll() {
        //加载配置
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("mybatisConfig.xml");
            //2.获得SqlSessionFactory
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.
            sqlSession = sessionFactory.openSession(true);
            //4.
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            //
            List<Student> list = mapper.findAllAndCard();
            //遍历
            list.forEach(System.out::println);
        } catch (IOException e) {
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

    }
}
