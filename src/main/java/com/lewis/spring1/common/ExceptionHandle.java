package com.lewis.spring1.common;

import com.lewis.spring1.bean.ResultBean;
import com.lewis.spring1.common.exception.NullAttrException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自定义异常(示例)
 *
 * 异常捕获类
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBean handle(Exception e) {

        if (e instanceof NullAttrException) {
            return ResultHandler.error(ResultEnum.NULL_ATTR);
        }

        return ResultHandler.error(e.getMessage());
    }
}
