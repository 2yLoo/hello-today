package com.yy.hellotoday;

import com.yy.hellotoday.model.Couple;
import com.yy.hellotoday.model.Weather;
import com.yy.hellotoday.repository.CoupleRepository;
import com.yy.hellotoday.repository.WeatherRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 描述: MongoRepository测试类
 *
 * @author 2yLoo
 * @create 2019-05-09 18:42
 */
public class MongoRepositoryTest extends HelloTodayWeatherApplicationTests {

    @Autowired
    CoupleRepository coupleRepository;

    @Autowired
    WeatherRepository weatherRepository;

    @Test
    public void testSaveOneDay(){
        Couple couple = new Couple();
        couple.setMyEmail("yamolv@qq.com");
        couple.setUrEmail("yamolv@qq.com");
        couple.setUrProvince("湖南");
        couple.setUrCity("长沙");
        couple.setUrCounty("天心");
        couple.setEmailTitle("Hello TodayWeather!  ——From 2yLoo");
        couple.setUrName("cutie");
        couple.setMyName("hero");
        couple.setMyBirthday("1996-07-02");
        couple.setUrBirthday("1996-02-18");
        couple.setTogether("2017-05-01");
        // coupleRepository.save(couple);
    }

    @Test
    public void testFindWeather() {
        Weather weather = weatherRepository.findWeatherByIdIs("2019-05-11");
        System.out.println(weather);
    }
}