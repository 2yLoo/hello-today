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
     * @param province 省份
     * @param city     城市
     * @param county   县
     * @return 天气信息
     * @throws IOException IO异常
     */
    Weather getAndSaveWeather(String province, String city, String county) throws IOException;

    /**
     * 获取天气信息
     *
     * @param date 日期，格式：yyyy-MM-dd
     * @return 天气信息
     */
    Weather getWeather(String date);


}