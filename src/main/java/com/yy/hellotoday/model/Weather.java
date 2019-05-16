package com.yy.hellotoday.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.yy.hellotoday.model.weather.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * 描述: 天气实体类
 *
 * @author 2yLoo
 * @create 2019-05-11 12:28
 */
@Document
public class Weather implements Serializable {

    @Id
    private String id;

    private String date;

    private List<WeatherPerHour> forecast1h;

    private List<WeatherPerDay> forecast1d;

    private WeatherIndex index;

    private WeatherObserve observe;

    private List<WeatherRise> weatherRise;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<WeatherPerHour> getForecast1h() {
        return forecast1h;
    }

    public void setForecast1h(List<WeatherPerHour> forecast1h) {
        this.forecast1h = forecast1h;
    }

    public List<WeatherPerDay> getForecast1d() {
        return forecast1d;
    }

    public void setForecast1d(List<WeatherPerDay> forecast1d) {
        this.forecast1d = forecast1d;
    }

    public WeatherIndex getIndex() {
        return index;
    }

    public void setIndex(WeatherIndex index) {
        this.index = index;
    }

    public WeatherObserve getObserve() {
        return observe;
    }

    public void setObserve(WeatherObserve observe) {
        this.observe = observe;
    }

    public List<WeatherRise> getWeatherRise() {
        return weatherRise;
    }

    public void setWeatherRise(List<WeatherRise> weatherRise) {
        this.weatherRise = weatherRise;
    }
}