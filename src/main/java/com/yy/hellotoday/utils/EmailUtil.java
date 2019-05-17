package com.yy.hellotoday.utils;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

/**
 * 描述: 邮件发送工具
 *
 * @author 2yLoo
 * @create 2019-05-17 13:17
 */
@Component
public class EmailUtil {

    private JavaMailSender javaMailSender;

    public EmailUtil(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String sendFrom, String sender, String sendTo, String subject, String text) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sendFrom, sender);
            helper.setTo(sendTo);
            helper.setSubject(subject);
            helper.setText(text, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            System.out.println("邮件发送异常：");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            System.out.println("名称解析异常");
            e.printStackTrace();
        }
    }

}