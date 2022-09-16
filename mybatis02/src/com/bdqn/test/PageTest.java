package com.bdqn.test;

import com.bdqn.bean.Student;
import com.bdqn.mapper.StudentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * @创建时间 2022/9/15---19:25
 * @描述信息
 */

public class PageTest {
    /**
     * 分页
     */
    @Test
    public void pagination() {
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

            //分页操作--每页3条---第一页
            //设置分页参数
            PageHelper.startPage(1, 3);
            //查询
            List<Student> list = mapper.findAll();
            //使用pageInfo
            PageInfo<Student> pageInfo = new PageInfo<>(list);
            //获得分页数据
            System.out.println("数据:" + pageInfo.getList());
            System.out.println("是否是第一页" + pageInfo.isIsFirstPage());
            System.out.println("总记录数:" + pageInfo.getTotal());
            System.out.println("是否是最后一页:" + pageInfo.isIsLastPage());
            System.out.println("总页数:" + pageInfo.getPages());
            System.out.println("每页条数:" + pageInfo.getPageSize());
            System.out.println("当前第几页:" + pageInfo.getPageNum());
            System.out.println("上一页:" + pageInfo.getPrePage());
            System.out.println("下一页:" + pageInfo.getNextPage());

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
