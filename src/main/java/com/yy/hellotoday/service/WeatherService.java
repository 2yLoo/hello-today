package com.yy.hellotoday.service;

import com.yy.hellotoday.model.Weather;

import java.io.IOException;

/**
 * 描述: 天气服务类接口
 *
 * @author 2yLoo
 * @create 2019-05-09 15:29
 */
public interface WeatherService {

    /**
     * 保存天气信息
     *
     * @return 天气信息
     * @throws IOException IO异常
     */
    Weather saveWeather() throws IOException;


}