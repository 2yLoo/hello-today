package com.yy.hellotoday.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.yy.hellotoday.constant.WeatherConstant;
import com.yy.hellotoday.model.Weather;
import com.yy.hellotoday.dto.Weather7Day;
import com.yy.hellotoday.model.weather.ForecastPerDay;
import com.yy.hellotoday.model.weather.ForecastPerHour;
import com.yy.hellotoday.model.weather.WeatherRise;
import com.yy.hellotoday.repository.WeatherRepository;
import com.yy.hellotoday.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
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
    public Weather saveWeather() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://wis.qq.com/weather/common?source=pc&weather_type=observe%7Cforecast_1h%7Cforecast_24h%7Cindex%7Calarm%7Climit%7Ctips%7Crise&province=%E6%B9%96%E5%8D%97&city=%E9%95%BF%E6%B2%99&county=%E5%A4%A9%E5%BF%83&callback=jQuery111304357260138644963_1557555577200&_=1557555577206")
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("服务器端错误: " + response);
        }

        String result = response.body().string();
        String data = result.substring(result.indexOf("{"), result.lastIndexOf(")"));
        System.out.println(data);
        JSONObject dataJson = JSONObject.parseObject(data).getJSONObject("data");
        Weather7Day weather7Day = JSONObject.toJavaObject(dataJson, Weather7Day.class);
        Weather weather = convertWeather(weather7Day);
        return weatherRepository.save(weather);
    }

    private Weather convertWeather(Weather7Day weather7Day) {
        Weather weather = new Weather();

        List<ForecastPerHour> forecastPerHours = new ArrayList<>();
        List<ForecastPerDay> forecastPerDays = new ArrayList<>();
        List<WeatherRise> rises = new ArrayList<>();

        for (int i = 0; i < WeatherConstant.SIZE_PER_HOUR; i++) {
            String index = String.valueOf(i);
            forecastPerHours.add(weather7Day.getForecast1h().get(index));

            if (i < WeatherConstant.SIZE_RISE) {
                rises.add(weather7Day.getRise().get(index));
                if (i < WeatherConstant.SIZE_PER_DAY) {
                    forecastPerDays.add(weather7Day.getForecast24h().get(index));
                }
            }
        }

        forecastPerHours.sort(new Comparator<ForecastPerHour>() {
            @Override
            public int compare(ForecastPerHour o1, ForecastPerHour o2) {
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
        for (ForecastPerHour forecastPerHour : forecastPerHours) {
            int time = Integer.valueOf(forecastPerHour.getUpdateTime().substring(8, 12));
            if ((node1 < time && time < node2) || (node3 < time && time < node4)) {
                day = true;
            }
            String icon = genIcon(day, forecastPerHour.getWeatherCode());
            forecastPerHour.setIcon(icon);
        }
        for (ForecastPerDay forecastPerDay : forecastPerDays) {
            String dayIcon = genIcon(true, forecastPerDay.getDayWeatherCode());
            String nightIcon = genIcon(false, forecastPerDay.getNightWeatherCode());
            forecastPerDay.setDayIcon(dayIcon);
            forecastPerDay.setNightIcon(nightIcon);
        }
        int time = Integer.valueOf(weather7Day.getObserve().getUpdateTime().substring(8));
        day = false;
        if ((node1 < time && time < node2) || (node3 < time && time < node4)) {
            day = true;
        }
        String icon = genIcon(day, weather7Day.getObserve().getWeatherCode());
        weather7Day.getObserve().setIcon(icon);

        weather.setId(getDate());
        weather.setForecast1h(forecastPerHours);
        weather.setForecast24h(forecastPerDays);
        weather.setWeatherRise(rises);
        weather.setObserve(weather7Day.getObserve());
        weather.setIndex(weather7Day.getIndex());
        return weather;
    }

    private String getDate() {
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dt);
    }

    private String genIcon(boolean day, String code) {
        return day ? String.format(WeatherConstant.ICON_URL_DAY, code) : String.format(WeatherConstant.ICON_URL_NIGHT, code);
    }

}