package com.yy.hellotoday.repository;

import com.yy.hellotoday.model.Weather;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 描述: 天气Repository接口
 *
 * @author 2yLoo
 * @create 2019-05-11 13:45
 */
public interface WeatherRepository extends MongoRepository<Weather, String> {

    /**
     * 根据ID获取天气信息
     *
     * @param id id
     * @return 天气信息
     */
    Weather findWeatherByIdIs(String id);
}