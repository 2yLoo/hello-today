package com.yy.hellotoday.job;

import com.yy.hellotoday.service.TodayService;
import com.yy.hellotoday.service.WeatherService;
import com.yy.hellotoday.utils.EmailUtil;
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

    private WeatherService weatherService;

    private EmailUtil emailUtil;

    @Autowired
    private TodayService todayService;

    @Autowired
    public EmailJob(WeatherService weatherService, EmailUtil emailUtil) {
        this.weatherService = weatherService;
        this.emailUtil = emailUtil;
    }

    @Scheduled(cron = "0 0 8 * * ?")
    public void emailEveryday(){
        emailUtil.sendTodayMail();
    }

    @Scheduled(cron = "*/10 * 0 * * ?")
    public void test(){
        emailUtil.test();
    }

    public void saveWeather(){
        todayService.saveTodayWeather();
    }

}