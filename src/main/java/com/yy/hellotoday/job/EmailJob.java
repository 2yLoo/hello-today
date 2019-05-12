package com.yy.hellotoday.job;

import com.yy.hellotoday.service.WeatherService;
import com.yy.hellotoday.utils.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

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
    public EmailJob(WeatherService weatherService, EmailUtil emailUtil) {
        this.weatherService = weatherService;
        this.emailUtil = emailUtil;
    }

    // @Scheduled(cron = "0/5 * * * * ?")
    public void emailEveryday(){

        weatherService.getWeather("2019-05-11");
        emailUtil.sendTodayMail();

    }

}