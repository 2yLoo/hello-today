package com.yy.hellotoday.service.impl;

import com.yy.hellotoday.constant.TipConstant;
import com.yy.hellotoday.constant.WeatherConstant;
import com.yy.hellotoday.dto.TodayWeatherDayDTO;
import com.yy.hellotoday.dto.TodayWeatherHourDTO;
import com.yy.hellotoday.dto.TodayWeatherTipsDTO;
import com.yy.hellotoday.model.Couple;
import com.yy.hellotoday.model.One;
import com.yy.hellotoday.model.TodayWeather;
import com.yy.hellotoday.model.Weather;
import com.yy.hellotoday.model.weather.*;
import com.yy.hellotoday.repository.TodayWeatherRepository;
import com.yy.hellotoday.service.CoupleService;
import com.yy.hellotoday.service.OneService;
import com.yy.hellotoday.service.TodayService;
import com.yy.hellotoday.service.WeatherService;
import com.yy.hellotoday.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

/**
 * 描述: 今日服务实现类
 *
 * @author 2yLoo
 * @create 2019-05-11 21:49
 */
@Service
public class TodayServiceImpl implements TodayService {

    @Autowired
    private CoupleService coupleService;

    @Autowired
    private WeatherService weatherService;
    @Autowired
    private OneService oneService;

    @Autowired
    private TodayWeatherRepository todayWeatherRepository;

    @Override
    public void saveTodayWeather() {
        List<Couple> couples = coupleService.findAll();
        final String date = DateUtil.genDate();
        try {
            One one = oneService.getAndSaveOne();
            for (Couple couple : couples) {
                try {
                    Weather weather = weatherService.getAndSaveWeather(couple.getUrProvince(), couple.getUrCity(), couple.getUrCounty());

                    TodayWeather todayWeather = saveTodayWeather(couple, weather, one, date);
                } catch (IOException e) {
                    System.out.println("天气获取异常");
                }
            }
        } catch (IOException e) {
            System.out.println("一个获取异常");
        }

    }

    @Override
    public List<TodayWeather> findByDate(String date) {
        return todayWeatherRepository.findAllByDate(date);
    }

    private TodayWeather saveTodayWeather(Couple couple, Weather weather, One one, String date) {
        TodayWeather todayWeather = new TodayWeather();

        todayWeather.setDate(date);

        // Couple信息
        todayWeather.setSendFrom(couple.getMyEmail());
        todayWeather.setSender(couple.getMyName());
        todayWeather.setSendTo(couple.getUrEmail());
        todayWeather.setTitle(couple.getEmailTitle());


        // 《一个》图片及文案
        todayWeather.setImage(one.getImage());
        todayWeather.setContent(one.getContent());

        // 总览天气信息
        WeatherObserve observe = weather.getObserve();
        todayWeather.setDegree(observe.getDegree());
        todayWeather.setHumidity(observe.getHumidity());
        todayWeather.setIcon(observe.getIcon());
        todayWeather.setWeather(observe.getWeather());
        String windCode = observe.getWindDirection();
        todayWeather.setWindDirection(getWindDirection(windCode));
        todayWeather.setWindPower(observe.getWindPower());

        // 当天日出日落
        WeatherRise rise = weather.getWeatherRise().get(0);
        TodayWeatherHourDTO sunrise = new TodayWeatherHourDTO(rise.getSunrise(), WeatherConstant.ICON_URL_SUNRISE, WeatherConstant.SUNRIZE);
        TodayWeatherHourDTO sunset = new TodayWeatherHourDTO(rise.getSunset(), WeatherConstant.ICON_URL_SUNSET, WeatherConstant.SUNSET);

        List<TodayWeatherHourDTO> hourDTOList = new ArrayList<>(WeatherConstant.SIZE_SHOW + 2);
        hourDTOList.add(sunrise);
        hourDTOList.add(sunset);
        List<WeatherPerHour> perHourList = weather.getForecast1h();
        String d = date.replace("-", "");
        String eight = d + "080000";
        String twelve = d + "120000";
        String fifteen = d + "150000";
        String eighteen = d + "180000";
        String twentyOne = d + "210000";
        for (WeatherPerHour weatherPerHour : perHourList) {
            TodayWeatherHourDTO dto = null;
            String time = weatherPerHour.getUpdateTime();
            if (eight.equals(time)) {
                dto = new TodayWeatherHourDTO("08:00", weatherPerHour.getIcon(), weatherPerHour.getDegree());
            } else if (twelve.equals(time)) {
                dto = new TodayWeatherHourDTO("12:00", weatherPerHour.getIcon(), weatherPerHour.getDegree());
            } else if (fifteen.equals(time)) {
                dto = new TodayWeatherHourDTO("15:00", weatherPerHour.getIcon(), weatherPerHour.getDegree());
            } else if (eighteen.equals(time)) {
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
        for (int i = 0; i < WeatherConstant.SIZE_SHOW; i++) {
            WeatherPerDay day = perDayList.get(i);
            TodayWeatherDayDTO dto = new TodayWeatherDayDTO(day.getDayWeatherShort(), day.getDayIcon(), day.getMaxDegree(), day.getMinDegree(), day.getNightIcon(), day.getNightWeatherShort());
            dayDTOList.add(dto);
        }
        todayWeather.setForecast1d(dayDTOList);

        List<TodayWeatherTipsDTO> tips = genTips(couple, weather, date);
        todayWeather.setTips(tips);

        TodayWeather dbResult = todayWeatherRepository.findBySendToAndDate(todayWeather.getSendTo(), todayWeather.getDate());
        if (dbResult == null) {
            todayWeather = todayWeatherRepository.save(todayWeather);
        } else {
            todayWeather = dbResult;
        }

        return todayWeather;

    }

    private String getWindDirection(String windCode) {
        String windDirection = "";
        switch (windCode) {
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
            default:
                break;
        }
        return windDirection;
    }

    private List<TodayWeatherTipsDTO> genTips(Couple couple, Weather weather, String date) {

        List<TodayWeatherTipsDTO> tips = new ArrayList<>();

        // TODO: 2019-05-16 警报

        if (date.endsWith(couple.getUrBirthday().substring(TipConstant.BIRTHDAY_INDEX))) {
            TodayWeatherTipsDTO tip = new TodayWeatherTipsDTO("小老鼠生日快乐🎂", "Sweet", 1);
            tips.add(tip);
        }
        if (date.endsWith(couple.getUrBirthday().substring(TipConstant.BIRTHDAY_INDEX))) {
            TodayWeatherTipsDTO tip = new TodayWeatherTipsDTO("老子生日你送啥？！！", "Sweet", 1);
            tips.add(tip);
        }

        if (date.endsWith(TipConstant.FIVE_TWENTY)) {
            TodayWeatherTipsDTO tip = new TodayWeatherTipsDTO("心中明月，我爱你", "Sweet", 1);
            tips.add(tip);
        } else if (date.endsWith(TipConstant.VALENTINE)) {
            TodayWeatherTipsDTO tip = new TodayWeatherTipsDTO("送你一束小fafa🌺，Happy Valentine's Day!", "Sweet", 1);
            tips.add(tip);
        }

        String togetherTip = getTogetherTip(couple.getTogether());
        if (!StringUtils.isEmpty(togetherTip)) {
            TodayWeatherTipsDTO tip = new TodayWeatherTipsDTO(togetherTip, "Sweet", 1);
            tips.add(tip);
        }

        Random random = new Random();
        TodayWeatherTipsDTO weatherTip;
        if (weather.getObserve().getWeather().contains(TipConstant.RAIN)) {
            weatherTip = new TodayWeatherTipsDTO(weather.getIndex().getUmbrella().getDetail(), "Weather", 2);
        } else {
            if (Integer.valueOf(weather.getObserve().getDegree()) < TipConstant.TEMP_LOW) {
                // 防寒穿衣提醒
                weatherTip = new TodayWeatherTipsDTO(weather.getIndex().getClothes().getDetail(), "Weather", 2);
            } else if (Integer.valueOf(weather.getObserve().getDegree()) > TipConstant.TEMP_HIGH) {
                // 防晒提醒
                weatherTip = new TodayWeatherTipsDTO(weather.getIndex().getSunscreen().getDetail(), "Weather", 2);
            } else {
                // 情绪提醒
                weatherTip = new TodayWeatherTipsDTO(weather.getIndex().getMood().getDetail(), "Weather", 2);
            }
        }
        tips.add(weatherTip);
        if (random.nextBoolean()) {
            // 化妆提醒
            TodayWeatherTipsDTO tip = new TodayWeatherTipsDTO(weather.getIndex().getMakeup().getDetail(), "Weather", 2);
            tips.add(tip);
        }

        return tips;
    }


    private String getYourBirthdayTip(Date birthday) {
        String tip = null;
        int dayNum = DateUtil.daysPerYearBetween(new Date(), birthday);
        if (dayNum < 10 && dayNum > 0) {
            tip = "距离小可爱的生日还有" + dayNum + "天！";
        } else if (dayNum == 0) {
            tip = "Happy Birthday To My Little Princess！";
        }
        return tip;
    }

    private String getMyBirthdayTip(String date) {
        String tip = null;
        Date birthday = DateUtil.parseDate(date);
        int dayNum = DateUtil.daysPerYearBetween(new Date(), birthday);
        if (dayNum < 3 && dayNum > 0) {
            tip = "老子还有" + dayNum + "天就要生日了，你送啥！";
        } else if (dayNum == 0) {
            tip = "约吗？";
        }

        // 不设置我的生日提醒
        tip = null;
        return tip;
    }

    private String getTogetherTip(String date) {
        String tip = null;
        Date together = DateUtil.parseDate(date);
        Date today = new Date();
        int dayNum = DateUtil.daysBetween(together, today);
        if (dayNum >= 10000 && dayNum % 10000 == 0) {
            tip = "在一起的" + dayNum % 10000 + "万天里，我都爱你💗";
        } else if (dayNum >= 1000 && dayNum % 1000 == 0) {
            tip = "第" + dayNum + "的晨曦是你的眼";
        } else if (dayNum >= 100 && dayNum % 100 == 0) {
            tip = "刚热恋的今天";
        }
        if (today.getMonth() == together.getMonth() && today.getDay() == together.getDay()) {
            tip = "今天是我们在一起" + (today.getYear() - together.getYear()) + "年纪念日哟";
        }
        return tip;
    }

    private String getWeddingTip(Date secret) {
        return "我们还莫有结婚";
    }

    // @Override
    // public TodayWeather getTodayWeather(String date) {
    //     Weather weather = weatherService.getWeather(date);
    //     One one = oneService.getOne(date);
    //     return saveTodayWeather(weather, one, date);
    // }

}