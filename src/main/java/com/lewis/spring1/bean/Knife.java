package com.lewis.spring1.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data //实体类
public class Knife {
    private Integer id;
    private String name;
    private Integer atk;
    private Integer hit;
    private Integer crit;
//    private Integer attr_id;
//    private Integer type_id;
    private String type_name;//改为String
    private String attr;//改为String
}
