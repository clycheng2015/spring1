package com.lewis.spring1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailService {
    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private JavaMailSender mJavaMailSender;

    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(content);
        msg.setFrom(from);

        mJavaMailSender.send(msg);
    }

    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage msg = mJavaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        helper.setFrom(from);

        mJavaMailSender.send(msg);

    }


    /**
     * 带附件
     *
     * @param to      收信人
     * @param subject 主题
     * @param content 内容
     * @param paths   路径
     * @throws MessagingException
     */
    public void sendSubFileMail(String to, String subject, String content, String... paths) throws MessagingException {
        MimeMessage msg = mJavaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        helper.setFrom(from);
        for (String path : paths) {
            FileSystemResource fsr = new FileSystemResource(new File(path));
            String filename = fsr.getFilename();
            System.out.println(filename);
            helper.addAttachment(filename, fsr);
        }
        mJavaMailSender.send(msg);
    }

}

