package com.bdqn.mapper;

import com.bdqn.bean.Card;

import java.util.List;

/**
 * @author 11752
 * @创建人 zby
 * @创建时间 2022/9/16---17:45
 * @描述信息
 */

public interface OneToOneMapper {

    /** 查询所有*/
    List<Card> findAll();
}
