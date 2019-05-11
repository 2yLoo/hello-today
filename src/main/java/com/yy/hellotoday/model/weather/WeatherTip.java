package com.yy.hellotoday.model.weather;

import java.io.Serializable;

/**
 * 描述: 天气提示
 *
 * @author 2yLoo
 * @create 2019-05-11 12:23
 */
public class WeatherTip implements Serializable {

    private String detail;

    private String info;

    private String name;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WeatherTip{" +
                "detail='" + detail + '\'' +
                ", info='" + info + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}