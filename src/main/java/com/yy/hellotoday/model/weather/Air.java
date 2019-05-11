package com.yy.hellotoday.model.weather;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 描述: 空气信息
 *
 * @author 2yLoo
 * @create 2019-05-11 10:42
 */
public class Air {

    /**
     * 空气湿度
     */
    private String aqi;
    /**
     * 湿度等级
     */
    private int aqiLevel;
    /**
     * 湿度中文等级
     */
    private String aqiName;
    /**
     * 空气质量指数
     */
    private String co;
    /**
     * 空气质量指数
     */
    private String no2;
    /**
     * 空气质量指数
     */
    private String o3;
    /**
     * 空气质量指数
     */
    private String pm10;
    /**
     * 空气质量指数
     */
    @JSONField(name = "pm2.5")
    private String pm25;
    /**
     * 空气质量指数
     */
    private String so2;
    /**
     * 更细时间
     */
    private String updateTime;

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public int getAqiLevel() {
        return aqiLevel;
    }

    public void setAqiLevel(int aqiLevel) {
        this.aqiLevel = aqiLevel;
    }

    public String getAqiName() {
        return aqiName;
    }

    public void setAqiName(String aqiName) {
        this.aqiName = aqiName;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getNo2() {
        return no2;
    }

    public void setNo2(String no2) {
        this.no2 = no2;
    }

    public String getO3() {
        return o3;
    }

    public void setO3(String o3) {
        this.o3 = o3;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getSo2() {
        return so2;
    }

    public void setSo2(String so2) {
        this.so2 = so2;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

}