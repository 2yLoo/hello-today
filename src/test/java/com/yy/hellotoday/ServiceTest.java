package com.yy.hellotoday;

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
public class ServiceTest extends HelloTodayApplicationTests {

    @Autowired
    private WeatherService weatherService;

    @Test
    public void testSaveWeather() throws IOException {
        weatherService.saveWeather("湖南", "长沙", "天心");
    }
}