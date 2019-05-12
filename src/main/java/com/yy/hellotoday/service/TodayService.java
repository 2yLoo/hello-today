package com.yy.hellotoday.service;

import com.yy.hellotoday.model.TodayWeather;

/**
 * 描述: 今日服务类接口
 *
 * @author 2yLoo
 * @create 2019-05-11 21:47
 */
public interface TodayService {

    /**
     * 获取今日天气信息
     *
     * @param date 日期，格式：yyyy-MM-dd
     * @return 今日天气信息
     */
    TodayWeather getTodayWeather(String date);
}