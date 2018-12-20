package com.lewis.spring1.service;

import com.lewis.spring1.bean.Sword;
import com.lewis.spring1.repository.SwordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/**
 * 加上事务 @Transactional的插入动作，在执行多条插入动作时，保证“同生共死”，所有动作，要买都失败要么都成功，
 * 不加事务，则有可能只插入部分
 *
 * */
@Service
public class SwordSameService {
    @Autowired
    private SwordRepository mSwordRepository;

    @Transactional
    public void insertTwo() {
        Sword jie = new Sword();
        jie.setName("解剑");
        jie.setInfo("幻将录jie--何解莲");
        mSwordRepository.save(jie);

        Sword lian = new Sword();
        lian.setName("连剑");
        //在这故意给个异常看看结果
        lian.setInfo("幻将录lian--何解莲");
        mSwordRepository.save(lian);
    }
}
