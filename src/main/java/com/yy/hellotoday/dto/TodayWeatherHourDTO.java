package com.yy.hellotoday.dto;

/**
 * 描述: 今日天气每小时DTO
 *
 * @author 2yLoo
 * @create 2019-05-11 22:15
 */
public class TodayWeatherHourDTO {

    /**
     * 时间
     */
    private String time;
    /**
     * 图标
     */
    private String icon;
    /**
     * 温度/日出/日落
     */
    private String degree;

    public TodayWeatherHourDTO() {
    }

    public TodayWeatherHourDTO(String time, String icon, String degree) {
        this.time = time;
        this.icon = icon;
        this.degree = degree;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "TodayWeatherHourDTO{" +
                "time='" + time + '\'' +
                ", icon='" + icon + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }
}