package com.bdqn.bean;

/*
 * @创建人   zby
 * @创建时间 2022/9/13---19:25
 * @描述信息
 */

/**
 * @author 11752
 */
public class Student extends StuCard{
    private Integer id;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}'+super.toString();
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }
}
