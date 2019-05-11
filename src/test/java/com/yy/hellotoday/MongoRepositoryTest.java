package com.yy.hellotoday;

import com.yy.hellotoday.model.OneDay;
import com.yy.hellotoday.model.Weather;
import com.yy.hellotoday.repository.OneDayRepository;
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
    OneDayRepository oneDayRepository;

    @Autowired
    WeatherRepository weatherRepository;

    @Test
    public void testSaveOneDay(){
        OneDay oneDay = new OneDay();
        oneDay.setUs("test");
        oneDay.setMyBirthday(new Date());
        oneDay.setYourBirthday(new Date());
        oneDay.setWedding(new Date());
        oneDayRepository.save(oneDay);
    }

    @Test
    public void testFindWeather() {
        Weather weather = weatherRepository.findWeatherByIdIs("2019-05-11");
        System.out.println(weather);
    }
}