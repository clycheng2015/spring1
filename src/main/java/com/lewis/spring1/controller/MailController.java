package com.lewis.spring1.controller;

import com.lewis.spring1.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;

@RestController
public class MailController {

    @Autowired
    private MailService mMailService;

    @GetMapping("/send")
    public String send() {
        mMailService.sendSimpleMail("648177797@qq.com", "你好", "lewis spring boot");
        return "send";
    }

    @GetMapping("/sendHtml")
    public String sendHtml() {
        String html =
                "<html\n" +
                        "<body>\n" +
                        "<h3> Hello Toly</h3>\n" +
                        "</body>\n" +
                        "</html>";

        try {
            mMailService.sendHtmlMail("648177797@qq.com", "你好", html);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "send";
    }

    @GetMapping("/sendSubFile")
    public String sendSubFile() {
        String path = "F:\\SpringBootFiles\\lewis1.sql";
        String path2 = "F:\\SpringBootFiles\\Image\\a08b87d6277f9e2fc11760a11630e924b899f37d.jpg";
        try {
            mMailService.sendSubFileMail("648177797@qq.com", "你好", "lewis ni nihao", path, path2);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "sendSubFile";
    }

    @Autowired
    private TemplateEngine mTemplateEngine;

    /**
     *发送模板
     * */
    @GetMapping("/sendTempMail")
    public String sendTempMail() {
        Context context = new Context();
        context.setVariable("id", "99531e7006e0");
        String emailTemp = mTemplateEngine.process("emailTemp", context);
        try {
            mMailService.sendHtmlMail("648177797@qq.com", "模板邮件", emailTemp);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "OK";
    }


}

