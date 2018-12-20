package com.lewis.spring1.controller;

import com.lewis.spring1.bean.Sword;
import com.lewis.spring1.repository.SwordRepository;
import com.lewis.spring1.service.SwordSameService;
import com.lewis.spring1.service.SwordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@RestController
public class SwordController {
    @Autowired //获取实例
    private SwordRepository mSwordRepository;

    /**
     * @return json字符串显示
     */
    @GetMapping(value = "/swords/findAll")
    public List<Sword> findAllToJson() {
        return mSwordRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @GetMapping(value = "/swords/find/{id}")
    public Sword find(@PathVariable("id") Integer id) {
        return mSwordRepository.findById(id).get();
    }

    /**
     * @param name
     * @return
     */
    @GetMapping(value = "/swords/findByName/{name}")
    public List<Sword> findByAtk(@PathVariable("name") String name) {
        return mSwordRepository.findByName(name);
    }

    /**
     * 添加：返回插入对象的json字符串
     *
     * @return
     */
    @GetMapping(value = "/swords/insert")
    public Sword insert() {
        Sword sword = new Sword();
        sword.setInfo("《犬夜叉》杀生丸配件，初时是一把不能杀此世之物的治愈之刀，" +
                "属于彼世之刀，是刀刀斋用犬大将(斗牙王)的獠牙所打造的剑，" +
                "可通过斩杀冥界的使者令死者复活。" +
                "若是以真正的慈悲心使之发动，一挥刀能拯救百命");
        sword.setName("天生牙");
        sword.setOrigin("《犬夜叉》--杀生丸");
        sword.setCreate_time(new Date());
        sword.setModify_time(new Date());
        return mSwordRepository.save(sword);
    }

    /**
     * 添加：通过url传值构建对象
     *
     * 示例：
     * localhost:8080/swords/insert2?name=九虹&info=圣剑&origin=《幻将录》
     * @return
     */
    @GetMapping(value = "/swords/insert2")
    public Sword insert2(Sword sword) {
        return mSwordRepository.save(sword);
    }
    /**
     * 更新操作
     *
     * 根据id进行更新
     *
     * 参数类似于：?name=九虹&info=圣剑&origin=《幻将录》
     *
     * */
    @GetMapping(value = "/swords/updata/{id}")
    public Sword updata(Sword sword) {
        return mSwordRepository.save(sword);
    }

    @GetMapping(value = "/swords/delete/{id}")
    public void  delete(@PathVariable("id") Integer id) {
        mSwordRepository.deleteById(id);
    }

    /*----------------------------service------------------------------------------*/
    @Autowired //得到服务对象
    private SwordService mSwordService;
    @Autowired //得到服务对象
    private SwordSameService mSwordSameService;
    /**
     * 查询所有：返回json字符串
     *
     * @return
     */
    @GetMapping(value = "/swords/insetFromService")
    @Transactional
    public void insetByService() {
        mSwordService.insertTwo();
    }

    @GetMapping(value = "/swords/insetSameService")
    //@Transactional 事物的注解也可以加载这里，也可以放在具体的service中
    public void insetBySameService() {
        mSwordSameService.insertTwo();
    }

}
