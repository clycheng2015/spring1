package com.lewis.spring1.controller;

import com.lewis.spring1.bean.Sword;
import com.lewis.spring1.repository.SwordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller //注意由于是RequestBody 所以这里将@RestController拆分出来了
public class ShowPhotoController {

    @GetMapping("/show")
    public String swordList(Model model) {
        model.addAttribute("sword", new Sword());
        return "swordList";
    }

    @GetMapping("/add_form")
    public String greetingForm(Model model) {
        model.addAttribute("sword", new Sword());
        return "submit";
    }

    @Autowired
    private SwordRepository mSwordRepository;

    @PostMapping("/submit_form")
    public String greetingSubmit(@ModelAttribute Sword sword, HttpServletResponse response,
                                 @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "false";
        }
        String fileName = file.getOriginalFilename();//获取名字
        String path = "F:/test";
        File dest = new File(path + "/" + fileName);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        System.out.println(dest);
        try {
            file.transferTo(dest); //保存文件
            sword.setImgurl("http://localhost:8080/" + fileName);
            sword.setCreate_time(new Date());
            sword.setModify_time(new Date());
            mSwordRepository.save(sword);
            response.sendRedirect("/show");//重定向到展示页
            return "swordList";

        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            return "上传失败!";
        }
    }
}
