package com.yy.hellotoday.service;

import com.yy.hellotoday.model.TodayWeather;

import java.util.List;

/**
 * 描述: 今日服务类接口
 *
 * @author 2yLoo
 * @create 2019-05-11 21:47
 */
public interface TodayService {

    /**
     * 保存今日数据
     */
    void saveTodayWeathers();

    /**
     * 获取指定日期今日数据
     *
     * @param date 日期格式为：yyyy-MM-dd
     * @return 今日天气数据列表
     */
    List<TodayWeather> findByDate(String date);
}