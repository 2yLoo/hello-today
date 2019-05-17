package com.yy.hellotoday.repository;

import com.yy.hellotoday.model.TodayWeather;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 描述: 今日Repository接口
 *
 * @author 2yLoo
 * @create 2019-05-11 21:49
 */
public interface TodayWeatherRepository extends MongoRepository<TodayWeather, String> {

    /**
     * 根据收件人与日期查询今日天气
     *
     * @param sendTo 收件人
     * @param date   日期
     * @return 今日天气
     */
    TodayWeather findBySendToAndDate(String sendTo, String date);

    /**
     * 根据日期获取今日天气列表
     *
     * @param date 日期
     * @return 今日天气列表
     */
    List<TodayWeather> findAllByDate(String date);
}