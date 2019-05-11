package com.yy.hellotoday.model.weather;

/**
 * 描述: 日出日落
 *
 * @author 2yLoo
 * @create 2019-05-11 10:48
 */
public class WeatherRise {

    /**
     * 日出
     */
    private String sunrise;
    /**
     * 日落
     */
    private String sunset;
    /**
     * 日期 19960218
     */
    private String time;

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "WeatherRise{" +
                "sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}