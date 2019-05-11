package com.yy.hellotoday.constant;

/**
 * 描述: 天气常量接口
 *
 * @author 2yLoo
 * @create 2019-05-11 14:00
 */
public interface WeatherConstant {

    /**
     * Url
     */
    String URL_WITHOUT_TIMESTAMP = "https://wis.qq.com/weather/common?source=pc&weather_type=observe%7Cforecast_1h%7Cforecast_24h%7Cindex%7Calarm%7Climit%7Ctips%7Crise&callback=jQuery11130984566822418339_1557567295285&_=1557567295293";
    /**
     * Url
     */
    String URL = "https://wis.qq.com/weather/common?source=pc&weather_type=observe%7Cforecast_1h%7Cforecast_24h%7Cindex%7Calarm%7Climit%7Ctips%7Crise";
    /**
     * 默认省份
     */
    String DEFAULT_PROVINCE = "广东";
    /**
     * 默认城市
     */
    String DEFAULT_CITY = "深圳";
    /**
     * 默认区/县
     */
    String DEFAULT_COUNTY = "南山";
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
     * 日出
     */
    String SUNRIZE = "日出";
    /**
     * 日落
     */
    String SUNSET = "日落";
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
    /**
     * 天气展示列表元素个数
     */
    int SIZE_SHOW = 5;
}