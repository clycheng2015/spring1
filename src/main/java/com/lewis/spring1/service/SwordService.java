package com.lewis.spring1.service;

import com.lewis.spring1.bean.Sword;
import com.lewis.spring1.repository.SwordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SwordService {
    @Autowired
    private SwordRepository mSwordRepository;
    public void insertTwo() {
        Sword jie = new Sword();
        jie.setName("解剑");
        jie.setInfo("幻将录--何解莲");
        jie.setCreate_time(new Date());
        jie.setModify_time(new Date());
        mSwordRepository.save(jie);
    }

}
