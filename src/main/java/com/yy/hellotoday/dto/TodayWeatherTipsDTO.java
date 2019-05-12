package com.yy.hellotoday.dto;

import java.io.Serializable;

/**
 * 描述: 今日天气提醒DTO
 *
 * @author 2yLoo
 * @create 2019-05-12 10:53
 */
public class TodayWeatherTipsDTO implements Serializable {

    private String tip;

    private String type;

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TodayWeatherTipsDTO{" +
                "tip='" + tip + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}