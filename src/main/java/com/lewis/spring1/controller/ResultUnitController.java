package com.lewis.spring1.controller;

import com.lewis.spring1.bean.ResultBean;
import com.lewis.spring1.bean.Sword;
import com.lewis.spring1.common.ResultHandler;
import com.lewis.spring1.common.exception.NullAttrException;
import com.lewis.spring1.repository.SwordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResultUnitController {
    @Autowired
    private SwordRepository mSwordRepository;

    /**
     * 查询所有：返回json字符串
     *
     * @return
     */
    @GetMapping(value = "/swords/findFormat")
    public ResultBean findAllToJson() {
        List<Sword> reps = mSwordRepository.findAll();
        if (reps == null) {
            throw new NullAttrException(1001);//此处可以故意抛出自定义异常看看
        }
        return ResultHandler.ok(reps);
    }
}
