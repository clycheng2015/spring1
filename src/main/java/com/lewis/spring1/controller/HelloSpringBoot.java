package com.lewis.spring1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * 本接口配置字符
 *
 * @RequestMapping(value = "/hello")
 */

@RestController
public class HelloSpringBoot {
    //------配置文件字段使用
    @Value("${name}")
    private String lever;
    @Value("${atk}")
    private int atk;
    @Value("${desc}")
    private String desc;


    @GetMapping("/say")
    public String say() {
        return "你好，idea";
    }

    ////------get方式Url传参
    @GetMapping({"/id/{the_Param}"})
    public String id(@PathVariable("the_Param") Integer id) {
        return "id:" + id;
    }

    ////------get方式Url传参
    @GetMapping("/user")
    public String username(@RequestParam("username") String str) {
        return "username is:" + str;
    }

    @PostMapping("/postWithBody")
    public String postWithBody(@RequestParam(value = "name") String str) {
        System.out.println(str);
        return str;
    }

    @PostMapping("/PostString")
    public String postString(HttpServletRequest request) {
        ServletInputStream is = null;
        try {
            is = request.getInputStream();
            StringBuilder sb = new StringBuilder();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = is.read(buf)) != -1) {
                sb.append(new String(buf, 0, len));
            }
            System.out.println(sb.toString());
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @GetMapping("/YoGiOh")
    public String paramInRes() {
        return desc;
    }


    @Autowired //自动创建对象
    private MonsterProperties monster;

    @GetMapping("/monster")
    public String say1() {
        return monster.toString();
    }
}
