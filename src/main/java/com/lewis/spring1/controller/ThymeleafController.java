package com.lewis.spring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 作者：张风捷特烈
 * 时间：2018/7/16:16:08
 * 邮箱：1981462002@qq.com
 * 说明：Thymeleaf模板引擎控制器
 */
@Controller //注意由于是RequestBody 所以这里将@RestController拆分出来了
public class ThymeleafController {

    @GetMapping("/HelloThymeleaf")
    public String say() {
        return "start";
    }
    @GetMapping("/useData")
    public String useData(ModelMap map) {
        map.addAttribute("replace_text", "lewis");
        return "start";
    }
}

