package com.yy.hellotoday.model.weather;

import java.io.Serializable;

/**
 * 描述: 每日天气
 *
 * @author 2yLoo
 * @create 2019-05-11 12:13
 */
public class ForecastPerDay implements Serializable {
    /**
     * 白天天气
     */
    private String dayWeather;
    /**
     * 白天天气码
     */
    private String dayWeatherCode;
    /**
     * 白天天气简称
     */
    private String dayWeatherShort;
    /**
     * 白天风向
     */
    private String dayWindDirection;
    /**
     * 白天风向码
     */
    private String dayWindDirectionCode;
    /**
     * 白天风力
     */
    private String dayWindPower;
    /**
     * 白天风力码
     */
    private String dayWindPowerCode;
    /**
     * 最高温度
     */
    private String maxDegree;
    /**
     * 最低温度
     */
    private String minDegree;
    /**
     * 晚上天气
     */
    private String nightWeather;
    /**
     * 晚上天气码
     */
    private String nightWeatherCode;
    /**
     * 晚上天气简称
     */
    private String nightWeatherShort;
    /**
     * 晚上风向
     */
    private String nightWindDirection;
    /**
     * 晚上风向码
     */
    private String nightWindDirectionCode;
    /**
     * 晚上风力
     */
    private String nightWindPower;
    /**
     * 晚上风力码
     */
    private String nightWindPowerCode;
    /**
     * 时间
     */
    private String time;
    /**
     * 白天天气图标
     */
    private String dayIcon;
    /**
     * 晚上天气图标
     */
    private String nightIcon;

    public String getDayWeather() {
        return dayWeather;
    }

    public void setDayWeather(String dayWeather) {
        this.dayWeather = dayWeather;
    }

    public String getDayWeatherCode() {
        return dayWeatherCode;
    }

    public void setDayWeatherCode(String dayWeatherCode) {
        this.dayWeatherCode = dayWeatherCode;
    }

    public String getDayWeatherShort() {
        return dayWeatherShort;
    }

    public void setDayWeatherShort(String dayWeatherShort) {
        this.dayWeatherShort = dayWeatherShort;
    }

    public String getDayWindDirection() {
        return dayWindDirection;
    }

    public void setDayWindDirection(String dayWindDirection) {
        this.dayWindDirection = dayWindDirection;
    }

    public String getDayWindDirectionCode() {
        return dayWindDirectionCode;
    }

    public void setDayWindDirectionCode(String dayWindDirectionCode) {
        this.dayWindDirectionCode = dayWindDirectionCode;
    }

    public String getDayWindPower() {
        return dayWindPower;
    }

    public void setDayWindPower(String dayWindPower) {
        this.dayWindPower = dayWindPower;
    }

    public String getDayWindPowerCode() {
        return dayWindPowerCode;
    }

    public void setDayWindPowerCode(String dayWindPowerCode) {
        this.dayWindPowerCode = dayWindPowerCode;
    }

    public String getMaxDegree() {
        return maxDegree;
    }

    public void setMaxDegree(String maxDegree) {
        this.maxDegree = maxDegree;
    }

    public String getMinDegree() {
        return minDegree;
    }

    public void setMinDegree(String minDegree) {
        this.minDegree = minDegree;
    }

    public String getNightWeather() {
        return nightWeather;
    }

    public void setNightWeather(String nightWeather) {
        this.nightWeather = nightWeather;
    }

    public String getNightWeatherCode() {
        return nightWeatherCode;
    }

    public void setNightWeatherCode(String nightWeatherCode) {
        this.nightWeatherCode = nightWeatherCode;
    }

    public String getNightWeatherShort() {
        return nightWeatherShort;
    }

    public void setNightWeatherShort(String nightWeatherShort) {
        this.nightWeatherShort = nightWeatherShort;
    }

    public String getNightWindDirection() {
        return nightWindDirection;
    }

    public void setNightWindDirection(String nightWindDirection) {
        this.nightWindDirection = nightWindDirection;
    }

    public String getNightWindDirectionCode() {
        return nightWindDirectionCode;
    }

    public void setNightWindDirectionCode(String nightWindDirectionCode) {
        this.nightWindDirectionCode = nightWindDirectionCode;
    }

    public String getNightWindPower() {
        return nightWindPower;
    }

    public void setNightWindPower(String nightWindPower) {
        this.nightWindPower = nightWindPower;
    }

    public String getNightWindPowerCode() {
        return nightWindPowerCode;
    }

    public void setNightWindPowerCode(String nightWindPowerCode) {
        this.nightWindPowerCode = nightWindPowerCode;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDayIcon() {
        return dayIcon;
    }

    public void setDayIcon(String dayIcon) {
        this.dayIcon = dayIcon;
    }

    public String getNightIcon() {
        return nightIcon;
    }

    public void setNightIcon(String nightIcon) {
        this.nightIcon = nightIcon;
    }

    @Override
    public String toString() {
        return "ForecastPerDay{" +
                "dayWeather='" + dayWeather + '\'' +
                ", dayWeatherCode='" + dayWeatherCode + '\'' +
                ", dayWeatherShort='" + dayWeatherShort + '\'' +
                ", dayWindDirection='" + dayWindDirection + '\'' +
                ", dayWindDirectionCode='" + dayWindDirectionCode + '\'' +
                ", dayWindPower='" + dayWindPower + '\'' +
                ", dayWindPowerCode='" + dayWindPowerCode + '\'' +
                ", maxDegree='" + maxDegree + '\'' +
                ", minDegree='" + minDegree + '\'' +
                ", nightWeather='" + nightWeather + '\'' +
                ", nightWeatherCode='" + nightWeatherCode + '\'' +
                ", nightWeatherShort='" + nightWeatherShort + '\'' +
                ", nightWindDirection='" + nightWindDirection + '\'' +
                ", nightWindDirectionCode='" + nightWindDirectionCode + '\'' +
                ", nightWindPower='" + nightWindPower + '\'' +
                ", nightWindPowerCode='" + nightWindPowerCode + '\'' +
                ", time='" + time + '\'' +
                ", dayIcon='" + dayIcon + '\'' +
                ", nightIcon='" + nightIcon + '\'' +
                '}';
    }
}