package com.lewis.spring1.controller;

import com.github.pagehelper.PageInfo;
import com.lewis.spring1.bean.Knife;
import com.lewis.spring1.service.KnifeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KnifeController {
    @Autowired
    private KnifeService mKnifeService;

    @GetMapping("/insert")
    public String insertSword(String name, Integer atk,
                              Integer hit,
                              Integer crit,
                              Integer attr_id,
                              Integer type_id) {

        mKnifeService.insertSword(name, atk, hit, crit, attr_id, type_id);

        return "OK";
    }

    @GetMapping("/findByName")
    public Knife findByName(String name) {
        return mKnifeService.findByName(name);
    }

    //http://localhost:8080/findAllByPage?page=1&pageSize=3
    @GetMapping("/findAllByPage")
    public PageInfo<Knife> findAll(int page, int pageSize) {
        return mKnifeService.findAll(page, pageSize);
    }
}
