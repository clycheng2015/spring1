package com.lewis.spring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * 作者：张风捷特烈
 * 时间：2018/5/29:23:15
 * 邮箱：1981462002@qq.com
 * 说明：文件上传控制器
 */
@Controller
public class UpFileController {
    @GetMapping("/upload_html")
    public String uploadHtml() {
        return "upfile";
    }

    //处理文件上传
    @PostMapping(value = "/upload")
    @ResponseBody
    public String uploadImg(@RequestParam("file1") MultipartFile file) {

        if (file.isEmpty()) {
            return "false";
        }
        String fileName = file.getOriginalFilename();//获取名字

        String path = "F:/test";
        File dest = new File(path + "/" + fileName);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            return "上传成功!";
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            return "上传失败!";
        }
    }

    @PostMapping(value = "/PostFile")
    @ResponseBody
    public String postFile(HttpServletRequest request) {
        String result = "";
        ServletInputStream is = null;
        FileOutputStream fos = null;
        try {
            File file = new File("F:/test", "up.png");
            fos = new FileOutputStream(file);
            is = request.getInputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = is.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            result = "SUCCESS";
        } catch (IOException e) {
            e.printStackTrace();
            result = "ERROR";
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 多文件上传(包括一个)
     *
     * @param files
     * @return
     */
    @PostMapping(value = "/uploadList")
    @ResponseBody
    public String uploadImg(@RequestParam("file1") List<MultipartFile> files) {
        StringBuilder result = new StringBuilder();
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                return "false";
            }
            String fileName = file.getOriginalFilename();//获取名字
            String path = "F:/test";
            File dest = new File(path + "/" + fileName);
            if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                dest.getParentFile().mkdir();
            }
            try {
                file.transferTo(dest); //保存文件
                result.append(fileName + "上传成功!\n");
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
                result.append(fileName + "上传失败!\n");
            }
        }
        return result.toString();
    }


}
