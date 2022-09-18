package com.bdqn.bean;

import java.util.List;

/**
 * @author 11752
 * @创建人 zby
 * @创建时间 2022/9/18---12:12
 * @描述信息 班级--一的一放
 */

public class Classes {
    private Integer id;
    private String name;
    /**
     * 一个班有多个学生
     */
    private List<Student> list;

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", list=" + list +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public Classes(Integer id, String name, List<Student> list) {
        this.id = id;
        this.name = name;
        this.list = list;
    }

    public Classes() {
    }
}
