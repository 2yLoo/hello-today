package com.yy.hellotoday.model.weather;

import java.io.Serializable;

/**
 * 描述: 天气总览
 *
 * @author 2yLoo
 * @create 2019-05-11 12:25
 */
public class WeatherObserve implements Serializable {

    /**
     * 温度
     */
    private String degree;
    /**
     * 湿度
     */
    private String humidity;
    /**
     * 降雨量
     */
    private String precipitation;
    /**
     * 大气压强
     */
    private String pressure;
    /**
     * 时间
     */
    private String updateTime;
    /**
     * 天气
     */
    private String weather;
    /**
     * 天气码
     */
    private String weatherCode;
    /**
     * 天气简称
     */
    private String weatherShort;
    /**
     * 风向
     */
    private String windDirection;
    /**
     * 风力
     */
    private String windPower;
    /**
     * 天气图标
     */
    private String icon;

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

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }

    public String getWeatherShort() {
        return weatherShort;
    }

    public void setWeatherShort(String weatherShort) {
        this.weatherShort = weatherShort;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "WeatherObserve{" +
                "degree='" + degree + '\'' +
                ", humidity='" + humidity + '\'' +
                ", precipitation='" + precipitation + '\'' +
                ", pressure='" + pressure + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", weather='" + weather + '\'' +
                ", weatherCode='" + weatherCode + '\'' +
                ", weatherShort='" + weatherShort + '\'' +
                ", windDirection='" + windDirection + '\'' +
                ", windPower='" + windPower + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}