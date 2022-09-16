package com.bdqn.bean;

/**
 * @author 11752
 * @创建人 zby
 * @创建时间 2022/9/15---19:57
 * @描述信息
 */

/** 身份证
 * @author 11752*/
public class StuCard {
    private Integer cid;
    private String cardNum;
    private String address;

    @Override
    public String toString() {
        return "StuCard{" +
                "cid=" + cid +
                ", cardNum='" + cardNum + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StuCard(Integer cid, String cardNum, String address) {
        this.cid = cid;
        this.cardNum = cardNum;
        this.address = address;
    }

    public StuCard() {
    }
}
 