package com.lewis.spring1.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lewis.spring1.bean.Knife;
import com.lewis.spring1.bean.mapper.KnifeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class KnifeService {

    @Autowired
    private KnifeMapper mKnifeMapper;

    @Transactional
    public void insertSword(String name, Integer atk,
                            Integer hit,
                            Integer crit,
                            Integer attr_id,
                            Integer type_id) {
        mKnifeMapper.insert(name, atk, hit, crit, attr_id, type_id);
    }

    public Knife findByName(String name) {
        return mKnifeMapper.findByName(name);
    }

    /**
     * 分页查询
     * @param page 当前页数
     * @param pageSize 每页个数
     * @return
     */
    public PageInfo<Knife>  findAll(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);//改写语句实现分页查询
        List<Knife> all = mKnifeMapper.findALL();
        PageInfo<Knife> info = new PageInfo<>(all);
        return info;
    }
}
