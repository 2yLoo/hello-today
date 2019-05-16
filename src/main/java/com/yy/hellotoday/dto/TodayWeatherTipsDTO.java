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

    private int priority;

    public TodayWeatherTipsDTO() {
    }

    public TodayWeatherTipsDTO(String tip, String type, int priority) {
        this.tip = tip;
        this.type = type;
        this.priority = priority;
    }

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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}