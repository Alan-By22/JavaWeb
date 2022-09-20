package com.bdqn.bean;

/**
 * @author 11752
 */
public class Student {
    private String sid;
    private String name;
    private Integer score;

    public Student() {
    }

    public Student(String sid, String name, Integer score) {
        this.sid = sid;
        this.name = name;
        this.score = score;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
