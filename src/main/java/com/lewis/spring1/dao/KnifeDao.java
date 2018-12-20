package com.lewis.spring1.dao;

import com.lewis.spring1.bean.Knife;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KnifeDao {

    List<Knife> findALL();

    Knife findByName(@Param("name") String name);

    //坑点1 java没有保存形参的记录，所以多参数用户@Param("name")起名字，不然无法识别
    int insert(@Param("name") String name,
               @Param("atk") Integer atk,
               @Param("hit") Integer hit,
               @Param("crit") Integer crit,
               @Param("attr_id") Integer attr_id,
               @Param("type_id") Integer type_id
    );
}

