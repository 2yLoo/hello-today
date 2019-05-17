package com.yy.hellotoday.job;

import com.yy.hellotoday.service.EmailService;
import com.yy.hellotoday.service.TodayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 描述: 邮件任务
 *
 * @author 2yLoo
 * @create 2019-05-09 16:41
 */
@Configuration
public class EmailJob {

    private EmailService emailService;

    private TodayService todayService;

    @Autowired
    public EmailJob(EmailService emailService, TodayService todayService) {
        this.emailService = emailService;
        this.todayService = todayService;
    }

    // 秒 分 时 日期 月份 星期 年（可选）
    @Scheduled(cron = "0 0 8 20-30 * ?")
    public void emailEveryday() {
        emailService.sendTodayMail();
    }

    @Scheduled(cron = "0 45 7 * * ?")
    public void saveTodayWeather() {
        todayService.saveTodayWeathers();
        // TODO: 2019-05-17 爬取异常
    }

    @Scheduled(cron = "*/15 * * * * ?")
    public void test() {
        emailService.test();
    }

}