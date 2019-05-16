package com.yy.hellotoday;

import com.yy.hellotoday.model.TodayWeather;
import com.yy.hellotoday.service.OneService;
import com.yy.hellotoday.service.TodayService;
import com.yy.hellotoday.service.WeatherService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * 描述:
 *
 * @author 2yLoo
 * @create 2019-05-11 12:01
 */
public class ServiceTest extends HelloTodayWeatherApplicationTests {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private OneService oneService;

    @Autowired
    private TodayService todayService;

    @Test
    public void testSaveWeather() throws IOException {
        // weatherService.saveWeather("湖南", "长沙", "天心");
    }

    @Test
    public void testSaveOne() throws IOException {
        oneService.getAndSaveOne();
    }

    @Test
    public void testSaveTodayWeather() {
        todayService.saveTodayWeather();
    }
}