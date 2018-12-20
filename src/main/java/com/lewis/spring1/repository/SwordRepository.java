package com.lewis.spring1.repository;

import com.lewis.spring1.bean.Sword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 仓储管理对象
 * */
public interface SwordRepository extends JpaRepository<Sword, Integer> {
    //通过name查询
    public List<Sword> findByName(String name);
}