package com.yy.hellotoday.model;

import com.yy.hellotoday.dto.TodayWeatherPerDayDTO;
import com.yy.hellotoday.dto.TodayWeatherPerHourDTO;
import com.yy.hellotoday.model.weather.WeatherPerDay;
import com.yy.hellotoday.model.weather.WeatherPerHour;
import com.yy.hellotoday.model.weather.WeatherRise;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 描述: 今日实体类
 *
 * @author yangyang.luo
 * @create 2019-05-11 21:37
 */
@Document
public class TodayWeather {

    @Id
    private String id;
    /**
     * 温度
     */
    private String degree;
    /**
     * 湿度
     */
    private String humidity;
    /**
     * 天气
     */
    private String weather;
    /**
     * 天气图标
     */
    private String icon;
    /**
     * 风向
     */
    private String windDirection;
    /**
     * 风力
     */
    private String windPower;
    /**
     * 首要提示
     */
    private String primaryTip;
    /**
     * 次要提示
     */
    private String secondaryTip;
    /**
     * 每小时天气
     */
    private List<TodayWeatherPerHourDTO> forecast1h;
    /**
     * 每天天气
     */
    private List<TodayWeatherPerDayDTO> forecast24h;
    /**
     * 每日图片
     */
    private String image;
    /**
     * 每日文案
     */
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindPower() {
        return windPower;
    }

    public void setWindPower(String windPower) {
        this.windPower = windPower;
    }

    public String getPrimaryTip() {
        return primaryTip;
    }

    public void setPrimaryTip(String primaryTip) {
        this.primaryTip = primaryTip;
    }

    public String getSecondaryTip() {
        return secondaryTip;
    }

    public void setSecondaryTip(String secondaryTip) {
        this.secondaryTip = secondaryTip;
    }

    public List<TodayWeatherPerHourDTO> getForecast1h() {
        return forecast1h;
    }

    public void setForecast1h(List<TodayWeatherPerHourDTO> forecast1h) {
        this.forecast1h = forecast1h;
    }

    public List<TodayWeatherPerDayDTO> getForecast24h() {
        return forecast24h;
    }

    public void setForecast24h(List<TodayWeatherPerDayDTO> forecast24h) {
        this.forecast24h = forecast24h;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}