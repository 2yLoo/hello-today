package com.yy.hellotoday.model.weather;

import java.io.Serializable;

/**
 * 描述: 天气限制
 *
 * @author 2yLoo
 * @create 2019-05-11 13:02
 */
public class WeatherLimit implements Serializable {

    /**
     * 尾数
     */
    private String tailNumber;
    /**
     * 时间
     */
    private String time;

    public String getTailNumber() {
        return tailNumber;
    }

    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "WeatherLimit{" +
                "tailNumber='" + tailNumber + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}