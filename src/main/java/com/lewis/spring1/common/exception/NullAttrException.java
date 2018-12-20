package com.lewis.spring1.common.exception;

import com.lewis.spring1.common.ResultEnum;

/**
 * 自定义异常(示例)
 * <p>
 * 说明：属性为空异常
 */
public class NullAttrException extends RuntimeException {
    private int code;
    private static String msg = ResultEnum.NULL_ATTR.getMsg();

    public NullAttrException(int code) {
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
