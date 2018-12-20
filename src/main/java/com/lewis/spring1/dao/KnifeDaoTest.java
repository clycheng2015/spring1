package com.lewis.spring1.dao;

import com.lewis.spring1.bean.Knife;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 单元测试---失败，提示：java.lang.ArrayStoreException: sun.reflect.annotation.TypeNotPresentExceptio
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class KnifeDaoTest {
    @Autowired
    private KnifeDao mKnifeDao;

    @Test
    public void findALL() {
        List<Knife> all = mKnifeDao.findALL();
        System.out.println(all.get(5));
//Sword(id=6, name=风跃, atk=9020, hit=10, crit=10, attr_id=2, type_id=2)
    }

    @Test
    public void findByName() {
        Knife 赤凰 = mKnifeDao.findByName("赤凰");
        System.out.println(赤凰);
//Sword(id=13, name=赤凰, atk=0, hit=100, crit=5, attr_id=1, type_id=2)
    }

    @Test
    public void insert() {
        int insert = mKnifeDao.insert("尤恨", 4000, 100, 100, 1, 1);
        System.out.println(insert);//1
    }
}

