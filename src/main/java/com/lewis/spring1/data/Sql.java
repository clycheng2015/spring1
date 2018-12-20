package com.lewis.spring1.data;

public interface Sql {
    String sql_creat_table = "CREATE TABLE sword("
            + "id int PRIMARY KEY NOT NULL COMMENT '身份验证码' AUTO_INCREMEN,T"
            + "name varchar(24) NOT NULL COMMENT '名称',"
            + "info text COMMENT '描述信息',"
            + "imgurl varchar(100) COMMENT '图片',"
            + "create_time datetime COMMENT '创建时间',"
            + "modify_time datetime COMMENT '修改时间',"
            + "origin varchar(40) COMMENT '来源')";

}
