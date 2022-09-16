package com.bdqn.mapper;

/*
 * @创建人   zby
 * @创建时间 2022/9/15---15:38
 * @描述信息
 */

import com.bdqn.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 11752
 */
public interface StudentMapper {

    /**使用mapper代理的方式要求
     * 1.映射文件.xml--namespace等于 mapper接口的全类名
     * 2.映射文件.xml中的(select,insert,update,delete)sql片段id等于对应mapper接口中的方法名
     * 3.映射文件.xml中(select,insert,update,delete)sql的resultType等于mapper接口中方法的返回值类型
     * 4.映射文件.xml中(select,insert,update,delete)sql的parameterType等于mapper接口中方法参数类型
     */

    /** 查询所有
     * find all
     * @return student;
     */
    List<Student> findAll();

    List<Student> findAllAndCard();

    /** 根据id查询
     * find Student By Id
     * @param integer;
     * @return student;
     */
    Student findStudentById(Integer integer);


    /** 添加
     * insert Student
     * @param student;
     * @return int;
     * */
    Integer insertStu(Student student);

    /** 修改
     * up Data Student
     * @param student;
     * */
    void upDataStu(Student student);

    /** 删除
     * up Data Student
     * @param id;
     * @return Integer;
     * */
    Integer deleteStuById(Integer id);

    /*动态查询*/
    /** 查询所有
     * dy find All
     * @param  student;
     * @return list;
     */
    List<Student> dyfindAll(Student student);


    /** 根据id查询
     * dy Find Foreach
     * @param  list;
     * @return list;
     */
    List<Student> dyFindForeach(List<Integer> list);
}
