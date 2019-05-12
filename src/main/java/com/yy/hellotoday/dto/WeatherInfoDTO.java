package com.yy.hellotoday.dto;

/**
 * 描述: 中国天气网天气实体类，暂用于测试类
 *
 * @author 2yLoo
 * @create 2019-05-09 15:50
 */
public class WeatherInfoDTO {

    /**
     * 城市
     */
    private String city;
    /**
     * 城市ID
     */
    private String cityId;
    /**
     * 温度
     */
    private String temp;
    /**
     * 风向
     */
    private String WD;
    /**
     * 风力（小于3级）
     */
    private String WS;
    /**
     * 相对湿度
     */
    private String SD;
    /**
     *
     */
    private String AP;
    /**
     * 暂无实况
     */
    private String njd;
    /**
     * <3
     */
    private String WSE;
    /**
     * 时间
     */
    private String time;

    private String sm;
    /**
     * 是否有雷达
     */
    private String isRadar;
    /**
     * 雷达
     */
    private String radar;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWD() {
        return WD;
    }

    public void setWD(String WD) {
        this.WD = WD;
    }

    public String getWS() {
        return WS;
    }

    public void setWS(String WS) {
        this.WS = WS;
    }

    public String getSD() {
        return SD;
    }

    public void setSD(String SD) {
        this.SD = SD;
    }

    public String getAP() {
        return AP;
    }

    public void setAP(String AP) {
        this.AP = AP;
    }

    public String getNjd() {
        return njd;
    }

    public void setNjd(String njd) {
        this.njd = njd;
    }

    public String getWSE() {
        return WSE;
    }

    public void setWSE(String WSE) {
        this.WSE = WSE;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public String getIsRadar() {
        return isRadar;
    }

    public void setIsRadar(String isRadar) {
        this.isRadar = isRadar;
    }

    public String getRadar() {
        return radar;
    }

    public void setRadar(String radar) {
        this.radar = radar;
    }

    @Override
    public String toString() {
        return "WeatherInfoDTO{" +
                "city='" + city + '\'' +
                ", cityId='" + cityId + '\'' +
                ", temp='" + temp + '\'' +
                ", WD='" + WD + '\'' +
                ", WS='" + WS + '\'' +
                ", SD='" + SD + '\'' +
                ", AP='" + AP + '\'' +
                ", njd='" + njd + '\'' +
                ", WSE='" + WSE + '\'' +
                ", time='" + time + '\'' +
                ", sm='" + sm + '\'' +
                ", isRadar='" + isRadar + '\'' +
                ", radar='" + radar + '\'' +
                '}';
    }
}