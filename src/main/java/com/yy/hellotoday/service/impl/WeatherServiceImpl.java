package com.yy.hellotoday.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.yy.hellotoday.constant.WeatherConstant;
import com.yy.hellotoday.model.Weather;
import com.yy.hellotoday.dto.Weather7Day;
import com.yy.hellotoday.model.weather.WeatherPerDay;
import com.yy.hellotoday.model.weather.WeatherPerHour;
import com.yy.hellotoday.model.weather.WeatherRise;
import com.yy.hellotoday.repository.WeatherRepository;
import com.yy.hellotoday.service.WeatherService;
import com.yy.hellotoday.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 描述: 天气服务接口实现类
 *
 * @author 2yLoo
 * @create 2019-05-09 15:30
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Override
    public Weather getAndSaveWeather(String province, String city, String county) throws IOException {
        OkHttpClient client = new OkHttpClient();
        // 省份与城市不可为空
        if (StringUtils.isEmpty(province) || StringUtils.isEmpty(city)){
            province = WeatherConstant.DEFAULT_PROVINCE;
            city = WeatherConstant.DEFAULT_CITY;
            county = WeatherConstant.DEFAULT_COUNTY;
        }
        // 进行中文的URL编码
        province = URLEncoder.encode(province, "UTF-8");
        city = URLEncoder.encode(city, "UTF-8");
        String params = String.format("&province=%s&city=%s", province, city);
        if (!StringUtils.isEmpty(county)) {
            county = URLEncoder.encode(county, "UTF-8");
            params +="&county="+county;
        }

        String url = WeatherConstant.URL+params;
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("服务器端错误: " + response);
        }
        String result = response.body().string();
        if (result.contains("jQuery")){
            result = result.substring(result.indexOf("{"), result.lastIndexOf(")"));
        }
        JSONObject dataJson = JSONObject.parseObject(result).getJSONObject("data");
        Weather7Day weather7Day = JSONObject.toJavaObject(dataJson, Weather7Day.class);
        Weather weather = convertWeather(weather7Day);
        return weatherRepository.save(weather);
    }

    private Weather convertWeather(Weather7Day weather7Day) {
        Weather weather = new Weather();

        List<WeatherPerHour> weatherPerHours = new ArrayList<>();
        List<WeatherPerDay> weatherPerDays = new ArrayList<>();
        List<WeatherRise> rises = new ArrayList<>();

        for (int i = 0; i < WeatherConstant.SIZE_PER_HOUR; i++) {
            String index = String.valueOf(i);
            weatherPerHours.add(weather7Day.getForecast1h().get(index));

            if (i < WeatherConstant.SIZE_RISE) {
                rises.add(weather7Day.getRise().get(index));
                if (i < WeatherConstant.SIZE_PER_DAY) {
                    weatherPerDays.add(weather7Day.getForecast24h().get(index));
                }
            }
        }

        weatherPerHours.sort(new Comparator<WeatherPerHour>() {
            @Override
            public int compare(WeatherPerHour o1, WeatherPerHour o2) {
                return o1.getUpdateTime().compareTo(o2.getUpdateTime());
            }
        });

        WeatherRise todayWeatherRise = rises.get(0);
        WeatherRise tomorrowWeatherRise = rises.get(1);
        int node1 = Integer.valueOf(todayWeatherRise.getSunrise().replace(":", ""));
        int node2 = Integer.valueOf(todayWeatherRise.getSunset().replace(":", ""));
        int node3 = Integer.valueOf(tomorrowWeatherRise.getSunrise().replace(":", ""));
        int node4 = Integer.valueOf(tomorrowWeatherRise.getSunset().replace(":", ""));

        boolean day = false;
        for (WeatherPerHour weatherPerHour : weatherPerHours) {
            int time = Integer.valueOf(weatherPerHour.getUpdateTime().substring(8, 12));
            if ((node1 < time && time < node2) || (node3 < time && time < node4)) {
                day = true;
            }
            String icon = genIcon(day, weatherPerHour.getWeatherCode());
            weatherPerHour.setIcon(icon);
        }
        for (WeatherPerDay weatherPerDay : weatherPerDays) {
            String dayIcon = genIcon(true, weatherPerDay.getDayWeatherCode());
            String nightIcon = genIcon(false, weatherPerDay.getNightWeatherCode());
            weatherPerDay.setDayIcon(dayIcon);
            weatherPerDay.setNightIcon(nightIcon);
        }
        int time = Integer.valueOf(weather7Day.getObserve().getUpdateTime().substring(8));
        day = (node1 < time && time < node2) || (node3 < time && time < node4);
        String icon = genIcon(day, weather7Day.getObserve().getWeatherCode());
        weather7Day.getObserve().setIcon(icon);

        weather.setDate(DateUtil.genDate());
        weather.setForecast1h(weatherPerHours);
        weather.setForecast1d(weatherPerDays);
        weather.setWeatherRise(rises);
        weather.setObserve(weather7Day.getObserve());
        weather.setIndex(weather7Day.getIndex());
        return weather;
    }

    private String genIcon(boolean day, String code) {
        return day ? String.format(WeatherConstant.ICON_URL_DAY, code) : String.format(WeatherConstant.ICON_URL_NIGHT, code);
    }

}