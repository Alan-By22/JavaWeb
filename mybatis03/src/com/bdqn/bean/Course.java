package com.bdqn.bean;

/**
 * @author 11752
 * @创建人 zby
 * @创建时间 2022/9/18---14:07
 * @描述信息  科目 多的一方
 */

public class Course {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
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

    public Course(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Course() {
    }
}
