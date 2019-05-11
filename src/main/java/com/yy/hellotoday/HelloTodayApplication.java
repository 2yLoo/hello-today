package com.yy.hellotoday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 描述: 你好今日邮件提醒
 *
 * @author 2yLoo
 */
@SpringBootApplication
@EnableScheduling
public class HelloTodayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloTodayApplication.class, args);
    }

}
