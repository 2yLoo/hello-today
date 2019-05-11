package com.yy.hellotoday.dto;

/**
 * 描述: 今日天气每日DTO
 *
 * @author yangyang.luo
 * @create 2019-05-11 22:42
 */
public class TodayWeatherPerDayDTO {
    /**
     * 白天天气简称
     */
    private String dayWeatherShort;
    /**
     * 白天天气图标
     */
    private String dayIcon;
    /**
     * 最高温度
     */
    private String maxDegree;
    /**
     * 最低温度
     */
    private String minDegree;
    /**
     * 晚上天气图标
     */
    private String nightIcon;
    /**
     * 晚上天气简称
     */
    private String nightWeatherShort;

    public TodayWeatherPerDayDTO() {
    }

    public TodayWeatherPerDayDTO(String dayWeatherShort, String dayIcon, String maxDegree, String minDegree, String nightIcon, String nightWeatherShort) {
        this.dayWeatherShort = dayWeatherShort;
        this.dayIcon = dayIcon;
        this.maxDegree = maxDegree;
        this.minDegree = minDegree;
        this.nightIcon = nightIcon;
        this.nightWeatherShort = nightWeatherShort;
    }

    public String getDayWeatherShort() {
        return dayWeatherShort;
    }

    public void setDayWeatherShort(String dayWeatherShort) {
        this.dayWeatherShort = dayWeatherShort;
    }

    public String getDayIcon() {
        return dayIcon;
    }

    public void setDayIcon(String dayIcon) {
        this.dayIcon = dayIcon;
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

    public String getNightIcon() {
        return nightIcon;
    }

    public void setNightIcon(String nightIcon) {
        this.nightIcon = nightIcon;
    }

    public String getNightWeatherShort() {
        return nightWeatherShort;
    }

    public void setNightWeatherShort(String nightWeatherShort) {
        this.nightWeatherShort = nightWeatherShort;
    }
}