package com.yy.hellotoday.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.yy.hellotoday.model.weather.*;

import java.util.Map;

/**
 * 描述:
 *
 * @author 2yLoo
 * @create 2019-05-11 12:28
 */
public class Weather7Day {

    @JSONField(name = "forecast_1h")
    private Map<String, WeatherPerHour> forecast1h;
    @JSONField(name = "forecast_24h")
    private Map<String, WeatherPerDay> forecast24h;

    private WeatherIndex index;

    private WeatherObserve observe;

    private Map<String, WeatherRise> rise;

    public Map<String, WeatherPerHour> getForecast1h() {
        return forecast1h;
    }

    public void setForecast1h(Map<String, WeatherPerHour> forecast1h) {
        this.forecast1h = forecast1h;
    }

    public Map<String, WeatherPerDay> getForecast24h() {
        return forecast24h;
    }

    public void setForecast24h(Map<String, WeatherPerDay> forecast24h) {
        this.forecast24h = forecast24h;
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

    public Map<String, WeatherRise> getRise() {
        return rise;
    }

    public void setRise(Map<String, WeatherRise> rise) {
        this.rise = rise;
    }

}