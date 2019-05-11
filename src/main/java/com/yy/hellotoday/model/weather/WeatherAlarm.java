package com.yy.hellotoday.model.weather;

import java.io.Serializable;

/**
 * 描述: 天气预警
 *
 * @author 2yLoo
 * @create 2019-05-11 15:14
 */
public class WeatherAlarm implements Serializable {
    /**
     * 城市
     */
    private String city;
    /**
     * 县
     */
    private String county;
    /**
     * 预警细节
     */
    private String detail;
    /**
     * 预警信息
     */
    private String info;
    /**
     * 预警级别
     */
    private String levelCode;
    /**
     * 预警级别名
     */
    private String levelName;
    /**
     * 省份
     */
    private String province;
    /**
     * 预警类别码
     */
    private String typeCode;
    /**
     * 预警类别
     */
    private String typeName;
    /**
     * 时间
     */
    private String updateTime;
    /**
     * 地址
     */
    private String url;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

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

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "WeatherAlarm{" +
                "city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", detail='" + detail + '\'' +
                ", info='" + info + '\'' +
                ", levelCode='" + levelCode + '\'' +
                ", levelName='" + levelName + '\'' +
                ", province='" + province + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", typeName='" + typeName + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}