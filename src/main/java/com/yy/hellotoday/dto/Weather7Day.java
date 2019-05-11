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
    private Map<String, ForecastPerHour> forecast1h;
    @JSONField(name = "forecast_24h")
    private Map<String, ForecastPerDay> forecast24h;

    private WeatherIndex index;

    private ForecastObserve observe;

    private Map<String, WeatherRise> rise;

    public Map<String, ForecastPerHour> getForecast1h() {
        return forecast1h;
    }

    public void setForecast1h(Map<String, ForecastPerHour> forecast1h) {
        this.forecast1h = forecast1h;
    }

    public Map<String, ForecastPerDay> getForecast24h() {
        return forecast24h;
    }

    public void setForecast24h(Map<String, ForecastPerDay> forecast24h) {
        this.forecast24h = forecast24h;
    }

    public WeatherIndex getIndex() {
        return index;
    }

    public void setIndex(WeatherIndex index) {
        this.index = index;
    }

    public ForecastObserve getObserve() {
        return observe;
    }

    public void setObserve(ForecastObserve observe) {
        this.observe = observe;
    }

    public Map<String, WeatherRise> getRise() {
        return rise;
    }

    public void setRise(Map<String, WeatherRise> rise) {
        this.rise = rise;
    }

}