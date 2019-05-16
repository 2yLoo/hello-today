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

    TodayWeather findBySendToAndDate(String sendTo, String date);

    List<TodayWeather> findAllByDate(String date);
}