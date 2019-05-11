package com.yy.hellotoday.constant;

/**
 * 描述: 天气常量接口
 *
 * @author 2yLoo
 * @create 2019-05-11 14:00
 */
public interface WeatherConstant {

    /**
     * 白天天气图标地址格式
     */
    String ICON_URL_DAY = "https://mat1.gtimg.com/pingjs/ext2020/weather/pc/icon/weather/day/%s.png";
    /**
     * 晚上天气图标地址格式
     */
    String ICON_URL_NIGHT = "https://mat1.gtimg.com/pingjs/ext2020/weather/pc/icon/weather/night/%s.png";
    /**
     * 日出图标地址
     */
    String ICON_URL_SUNRISE = "https://mat1.gtimg.com/pingjs/ext2020/weather/pc/icon/weather/rise.png";
    /**
     * 日落图标地址
     */
    String ICON_URL_SUNSET = "https://mat1.gtimg.com/pingjs/ext2020/weather/pc/icon/weather/set.png";
    /**
     * 每小时天气列表元素个数
     */
    int SIZE_PER_HOUR = 48;
    /**
     * 每天天气列表元素个数
     */
    int SIZE_PER_DAY = 8;
    /**
     * 日出日落列表元素个数
     */
    int SIZE_RISE = 15;
}