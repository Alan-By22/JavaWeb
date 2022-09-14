package com.bdqn.bean;

public class User {
    private int id;
    private String username;
    private String password;
    private Integer age;
    private String address;


    public User(int id, String username, String password, Integer age, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.address = address;
    }

    public User( String username, String password, Integer age, String address) {

        this.username = username;
        this.password = password;
        this.age = age;
        this.address = address;
    }

    public User( String username, String password) {

        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
