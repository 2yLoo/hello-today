package com.yy.hellotoday;

import com.yy.hellotoday.utils.EmailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloTodayWeatherApplicationTests {

    @Autowired
    EmailUtil emailUtil;

    @Test
    public void testSendEmail() {
        emailUtil.sendTodayMail();
    }


}
