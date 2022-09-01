package com.bdqn.bean;

/*
 * @创建人   zby
 * @创建时间 2022/8/31---19:01
 * @描述信息
 */
//用户的对象
public class User {
    private String name;
    private  Integer age;
    //一辆车
    private Car car;

    public User(String name, Integer age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public User() {
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
