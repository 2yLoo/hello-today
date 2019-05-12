package com.yy.hellotoday.service.impl;

import com.yy.hellotoday.constant.WeatherConstant;
import com.yy.hellotoday.dto.TodayWeatherDayDTO;
import com.yy.hellotoday.dto.TodayWeatherHourDTO;
import com.yy.hellotoday.dto.TodayWeatherTipsDTO;
import com.yy.hellotoday.model.One;
import com.yy.hellotoday.model.TodayWeather;
import com.yy.hellotoday.model.Weather;
import com.yy.hellotoday.model.weather.WeatherObserve;
import com.yy.hellotoday.model.weather.WeatherPerDay;
import com.yy.hellotoday.model.weather.WeatherPerHour;
import com.yy.hellotoday.model.weather.WeatherRise;
import com.yy.hellotoday.service.OneService;
import com.yy.hellotoday.service.TodayService;
import com.yy.hellotoday.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 描述: 今日服务实现类
 *
 * @author 2yLoo
 * @create 2019-05-11 21:49
 */
@Service
public class TodayServiceImpl implements TodayService {

    @Autowired
    private WeatherService weatherService;
    @Autowired
    private OneService oneService;

    @Override
    public TodayWeather getTodayWeather(String date) {
        Weather weather = weatherService.getWeather(date);
        One one = oneService.getOne(date);
        TodayWeather todayWeather = new TodayWeather();
        // 《一个》图片及文案
        todayWeather.setImage(one.getImage());
        todayWeather.setContent(one.getContent());

        // 总览天气信息
        WeatherObserve observe =weather.getObserve();
        todayWeather.setDegree(observe.getDegree());
        todayWeather.setHumidity(observe.getHumidity());
        todayWeather.setIcon(observe.getIcon());
        todayWeather.setWeather(observe.getWeather());
        String windDirection = observe.getWindDirection();
        switch (windDirection){
            case "1":
                windDirection = "东北风";
                break;
            case "2":
                windDirection = "东风";
                break;
            case "3":
                windDirection = "东南风";
                break;
            case "4":
                windDirection = "南风";
                break;
            case "5":
                windDirection = "西南风";
                break;
            case "6":
                windDirection = "西风";
                break;
            case "7":
                windDirection = "西北风";
                break;
            case "8":
                windDirection = "北风";
                break;
                default:break;
        }
        todayWeather.setWindDirection(windDirection);
        todayWeather.setWindPower(observe.getWindPower());

        // 当天日出日落
        WeatherRise rise = weather.getWeatherRise().get(0);
        TodayWeatherHourDTO sunrise = new TodayWeatherHourDTO(rise.getSunrise(), WeatherConstant.ICON_URL_SUNRISE,WeatherConstant.SUNRIZE);
        TodayWeatherHourDTO sunset = new TodayWeatherHourDTO(rise.getSunset(), WeatherConstant.ICON_URL_SUNSET, WeatherConstant.SUNSET);

        List<TodayWeatherHourDTO> hourDTOList = new ArrayList<>(WeatherConstant.SIZE_SHOW+2);
        hourDTOList.add(sunrise);
        hourDTOList.add(sunset);
        List<WeatherPerHour> perHourList = weather.getForecast1h();
        String d = date.replace("-","");
        String eight = d+"080000";
        String twelve = d+"120000";
        String fifteen = d+"150000";
        String eighteen = d + "180000";
        String twentyOne = d + "210000";
        for (WeatherPerHour weatherPerHour : perHourList) {
            TodayWeatherHourDTO dto = null;
            String time = weatherPerHour.getUpdateTime();
            if (eight.equals(time)){
                dto = new TodayWeatherHourDTO("08:00", weatherPerHour.getIcon(), weatherPerHour.getDegree());
            }else if (twelve.equals(time)){
                dto = new TodayWeatherHourDTO("12:00", weatherPerHour.getIcon(), weatherPerHour.getDegree());
            }else if (fifteen.equals(time)){
                dto = new TodayWeatherHourDTO("15:00", weatherPerHour.getIcon(), weatherPerHour.getDegree());
            }else if (eighteen.equals(time)){
                dto = new TodayWeatherHourDTO("18:00", weatherPerHour.getIcon(), weatherPerHour.getDegree());
            } else if (twentyOne.equals(time)) {
                dto = new TodayWeatherHourDTO("21:00", weatherPerHour.getIcon(), weatherPerHour.getDegree());
                hourDTOList.add(dto);
                break;
            }
            if (dto != null) {
                hourDTOList.add(dto);
            }
        }
        hourDTOList.sort(new Comparator<TodayWeatherHourDTO>() {
            @Override
            public int compare(TodayWeatherHourDTO o1, TodayWeatherHourDTO o2) {
                return o1.getTime().compareTo(o2.getTime());
            }
        });
        todayWeather.setForecast1h(hourDTOList);

        List<WeatherPerDay> perDayList = weather.getForecast1d();
        List<TodayWeatherDayDTO> dayDTOList = new ArrayList<>(WeatherConstant.SIZE_SHOW);
        for (int i = 0; i<WeatherConstant.SIZE_SHOW; i++) {
            WeatherPerDay day =  perDayList.get(i);
            TodayWeatherDayDTO dto = new TodayWeatherDayDTO(day.getDayWeatherShort(), day.getDayIcon(), day.getMaxDegree(), day.getMinDegree(), day.getNightIcon(), day.getNightWeatherShort());
            dayDTOList.add(dto);
        }
        todayWeather.setForecast1d(dayDTOList);

        List<TodayWeatherTipsDTO> tips = new ArrayList<>();
        todayWeather.setTips(tips);

        // todayWeather.setPrimaryTip(weather.getIndex().getClothes().getDetail());
        // todayWeather.setSecondaryTip(weather.getIndex().getMakeup().getDetail());

        return todayWeather;
    }

}