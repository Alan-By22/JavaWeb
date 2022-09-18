package com.bdqn.bean;

/**
 * @author 11752
 * @创建人 zby
 * @创建时间 2022/9/16---17:42
 * @描述信息
 */

public class Card {
    private Integer id;
    private String number;
    /**
     * 每一个人---身份证
     */
    private Person p;

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", p=" + p +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public Card(Integer id, String number, Person p) {
        this.id = id;
        this.number = number;
        this.p = p;
    }

    public Card() {
    }
}
