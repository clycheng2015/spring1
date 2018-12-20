package com.lewis.spring1.common;

public enum  ResultEnum {
    SUCCESS(1,"操作成功"),
    EXCEPTION(0, "系统异常"),
    NULL_ATTR(101,"属性为空");

    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
