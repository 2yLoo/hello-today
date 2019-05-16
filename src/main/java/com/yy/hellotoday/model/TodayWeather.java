package com.yy.hellotoday.model;

import com.yy.hellotoday.dto.TodayWeatherDayDTO;
import com.yy.hellotoday.dto.TodayWeatherHourDTO;
import com.yy.hellotoday.dto.TodayWeatherTipsDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * 描述: 今日实体类
 *
 * @author 2yLoo
 * @create 2019-05-11 21:37
 */
@Document
public class TodayWeather implements Serializable {

    @Id
    private String id;
    /**
     * 日期
     */
    private String date;
    /**
     * 发件人
     */
    private String sendFrom;
    /**
     * 收件人
     */
    private String sendTo;
    /**
     * 标题
     */
    private String title;
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
     * 提示
     */
    private List<TodayWeatherTipsDTO> tips;
    /**
     * 每小时天气
     */
    private List<TodayWeatherHourDTO> forecast1h;
    /**
     * 每天天气
     */
    private List<TodayWeatherDayDTO> forecast1d;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSendFrom() {
        return sendFrom;
    }

    public void setSendFrom(String sendFrom) {
        this.sendFrom = sendFrom;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<TodayWeatherTipsDTO> getTips() {
        return tips;
    }

    public void setTips(List<TodayWeatherTipsDTO> tips) {
        this.tips = tips;
    }

    public List<TodayWeatherHourDTO> getForecast1h() {
        return forecast1h;
    }

    public void setForecast1h(List<TodayWeatherHourDTO> forecast1h) {
        this.forecast1h = forecast1h;
    }

    public List<TodayWeatherDayDTO> getForecast1d() {
        return forecast1d;
    }

    public void setForecast1d(List<TodayWeatherDayDTO> forecast1d) {
        this.forecast1d = forecast1d;
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

    @Override
    public String toString() {
        return "TodayWeather{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", sendFrom='" + sendFrom + '\'' +
                ", sendTo='" + sendTo + '\'' +
                ", title='" + title + '\'' +
                ", degree='" + degree + '\'' +
                ", humidity='" + humidity + '\'' +
                ", weather='" + weather + '\'' +
                ", icon='" + icon + '\'' +
                ", windDirection='" + windDirection + '\'' +
                ", windPower='" + windPower + '\'' +
                ", tips=" + tips +
                ", forecast1h=" + forecast1h +
                ", forecast1d=" + forecast1d +
                ", image='" + image + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}