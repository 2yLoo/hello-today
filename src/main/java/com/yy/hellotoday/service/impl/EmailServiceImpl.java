package com.yy.hellotoday.service.impl;

import com.yy.hellotoday.model.TodayWeather;
import com.yy.hellotoday.service.EmailService;
import com.yy.hellotoday.service.TodayService;
import com.yy.hellotoday.utils.DateUtil;
import com.yy.hellotoday.utils.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述: 邮件服务实现类
 *
 * @author 2yLoo
 * @create 2019-05-09 16:06
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Value("${email.send.from}")
    private String from;

    @Value("${email.send.name}")
    private String sender;

    @Value("${email.send.to}")
    private String to;

    @Value("${email.title}")
    private String title;


    private TodayService todayService;

    private EmailUtil emailUtil;

    @Autowired
    public EmailServiceImpl(TodayService todayService, EmailUtil emailUtil) {
        this.todayService = todayService;
        this.emailUtil = emailUtil;
    }

    @Override
    public void sendTodayMail() {
        List<TodayWeather> todayWeathers = todayService.findByDate(DateUtil.genDate());
        for (TodayWeather todayWeather : todayWeathers) {
            // 获取text后再循环生成tips
            String text = genText(todayWeather);
            emailUtil.sendEmail(todayWeather.getSendFrom(), todayWeather.getSender(), todayWeather.getSendTo(), todayWeather.getTitle(), text);
        }
    }

    @Override
    public void test() {
        String text = "test";
        emailUtil.sendEmail(from, sender, to, title, text);
    }

    private String genText(TodayWeather todayWeather) {
        String degree = todayWeather.getDegree();
        String icon = todayWeather.getIcon();
        String tip1 = todayWeather.getTips().get(0).getTip();
        String tip2 = todayWeather.getTips().get(1).getTip();
        String humidity = todayWeather.getHumidity();
        String weather = todayWeather.getWeather();

        String text = TEMPLATE
                .replace("{degree}", degree)
                .replace("{icon}", icon)
                .replace("{humidity}", humidity)
                .replace("{weather}", weather)
                .replace("{wd}", todayWeather.getWindDirection())
                .replace("{wp}", todayWeather.getWindPower())
                .replace("{tip1}", tip1)
                .replace("{tip2}", tip2)
                .replace("{oneImg}", todayWeather.getImage())
                .replace("{oneContent}", todayWeather.getContent())
                .replace("{ht1}", todayWeather.getForecast1h().get(0).getTime())
                .replace("{ht2}", todayWeather.getForecast1h().get(1).getTime())
                .replace("{ht3}", todayWeather.getForecast1h().get(2).getTime())
                .replace("{ht4}", todayWeather.getForecast1h().get(3).getTime())
                .replace("{ht5}", todayWeather.getForecast1h().get(4).getTime())
                .replace("{ht6}", todayWeather.getForecast1h().get(5).getTime())
                .replace("{ht7}", todayWeather.getForecast1h().get(6).getTime())
                .replace("{hc1}", todayWeather.getForecast1h().get(0).getIcon())
                .replace("{hc2}", todayWeather.getForecast1h().get(1).getIcon())
                .replace("{hc3}", todayWeather.getForecast1h().get(2).getIcon())
                .replace("{hc4}", todayWeather.getForecast1h().get(3).getIcon())
                .replace("{hc5}", todayWeather.getForecast1h().get(4).getIcon())
                .replace("{hc6}", todayWeather.getForecast1h().get(5).getIcon())
                .replace("{hc7}", todayWeather.getForecast1h().get(6).getIcon())
                .replace("{hd1}", todayWeather.getForecast1h().get(0).getDegree())
                .replace("{hd2}", todayWeather.getForecast1h().get(1).getDegree())
                .replace("{hd3}", todayWeather.getForecast1h().get(2).getDegree())
                .replace("{hd4}", todayWeather.getForecast1h().get(3).getDegree())
                .replace("{hd5}", todayWeather.getForecast1h().get(4).getDegree())
                .replace("{hd6}", todayWeather.getForecast1h().get(5).getDegree())
                .replace("{hd7}", todayWeather.getForecast1h().get(6).getDegree())
                .replace("{dw1}", todayWeather.getForecast1d().get(0).getDayWeatherShort())
                .replace("{dw2}", todayWeather.getForecast1d().get(1).getDayWeatherShort())
                .replace("{dw3}", todayWeather.getForecast1d().get(2).getDayWeatherShort())
                .replace("{dw4}", todayWeather.getForecast1d().get(3).getDayWeatherShort())
                .replace("{dw5}", todayWeather.getForecast1d().get(4).getDayWeatherShort())
                .replace("{dc1}", todayWeather.getForecast1d().get(0).getDayIcon())
                .replace("{dc2}", todayWeather.getForecast1d().get(1).getDayIcon())
                .replace("{dc3}", todayWeather.getForecast1d().get(2).getDayIcon())
                .replace("{dc4}", todayWeather.getForecast1d().get(3).getDayIcon())
                .replace("{dc5}", todayWeather.getForecast1d().get(4).getDayIcon())
                .replace("{dd1}", todayWeather.getForecast1d().get(0).getMaxDegree())
                .replace("{dd2}", todayWeather.getForecast1d().get(1).getMaxDegree())
                .replace("{dd3}", todayWeather.getForecast1d().get(2).getMaxDegree())
                .replace("{dd4}", todayWeather.getForecast1d().get(3).getMaxDegree())
                .replace("{dd5}", todayWeather.getForecast1d().get(4).getMaxDegree())
                .replace("{nd1}", todayWeather.getForecast1d().get(0).getMinDegree())
                .replace("{nd2}", todayWeather.getForecast1d().get(1).getMinDegree())
                .replace("{nd3}", todayWeather.getForecast1d().get(2).getMinDegree())
                .replace("{nd4}", todayWeather.getForecast1d().get(3).getMinDegree())
                .replace("{nd5}", todayWeather.getForecast1d().get(4).getMinDegree())
                .replace("{nc1}", todayWeather.getForecast1d().get(0).getNightIcon())
                .replace("{nc2}", todayWeather.getForecast1d().get(1).getNightIcon())
                .replace("{nc3}", todayWeather.getForecast1d().get(2).getNightIcon())
                .replace("{nc4}", todayWeather.getForecast1d().get(3).getNightIcon())
                .replace("{nc5}", todayWeather.getForecast1d().get(4).getNightIcon())
                .replace("{nw1}", todayWeather.getForecast1d().get(0).getNightWeatherShort())
                .replace("{nw2}", todayWeather.getForecast1d().get(1).getNightWeatherShort())
                .replace("{nw3}", todayWeather.getForecast1d().get(2).getNightWeatherShort())
                .replace("{nw4}", todayWeather.getForecast1d().get(3).getNightWeatherShort())
                .replace("{nw5}", todayWeather.getForecast1d().get(4).getNightWeatherShort());
        return text;
    }

    private static final String TEMPLATE = "<html>\n" +
            "\n" +
            "<body>\n" +
            "<div>\n" +
            "<a><font face=\"verdana\" size=\"18\">{degree}°</font></a>\n" +
            "<img align=\"right\"  hight=100 width=100 src=\"{icon}\"/>\n" +
            "<a><font face=\"arial\" size=\"3\">{wd} {wp}级</font>&nbsp;<font face=\"arial\" size=\"3\">湿度 {humidity}%</font></a>\n" +
            "<br>\n" +
            "<a><font face=\"arial\" size=\"1\">{tip1}</font></a>\n" +
            "<br>\n" +
            "<a><font face=\"arial\" size=\"1\">{tip2}</font></a>\n" +
            "</div>\n" +
            "<br>\n" +
            "<div>\n" +
            "<table border=\"0\" width=\"100%\" >\n" +
            "<tr>\n" +
            "  <td align=\"center\">{ht1}</td>\n" +
            "  <td align=\"center\">{ht2}</td>\n" +
            "  <td align=\"center\">{ht3}</td>\n" +
            "  <td align=\"center\">{ht4}</td>\n" +
            "  <td align=\"center\">{ht5}</td>\n" +
            "  <td align=\"center\">{ht6}</td>\n" +
            "  <td align=\"center\">{ht7}</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "  <td align=\"center\"><img hight=30 width=30 src=\"{hc1}\"/></td>\n" +
            "  <td align=\"center\"><img hight=30 width=30 src=\"{hc2}\"/></td>\n" +
            "  <td align=\"center\"><img hight=30 width=30 src=\"{hc3}\"/></td>\n" +
            "  <td align=\"center\"><img hight=30 width=30 src=\"{hc4}\"/></td>\n" +
            "  <td align=\"center\"><img hight=30 width=30 src=\"{hc5}\"/></td>\n" +
            "  <td align=\"center\"><img hight=30 width=30 src=\"{hc6}\"/></td>\n" +
            "  <td align=\"center\"><img hight=30 width=30 src=\"{hc7}\"/></td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "  <td align=\"center\">{hd1}</td>\n" +
            "  <td align=\"center\">{hd2}</td>\n" +
            "  <td align=\"center\">{hd3}</td>\n" +
            "  <td align=\"center\">{hd4}</td>\n" +
            "  <td align=\"center\">{hd5}</td>\n" +
            "  <td align=\"center\">{hd6}</td>\n" +
            "  <td align=\"center\">{hd7}</td>\n" +
            "</table>\n" +
            "</div>\n" +
            "<div>\n" +
            "<table border=\"0\" width=\"100%\" align=\"left\">\n" +
            "<tr>\n" +
            "  <td align=\"center\">昨天的</td>\n" +
            "  <td align=\"center\">今天的</td>\n" +
            "  <td align=\"center\">明天的</td>\n" +
            "  <td align=\"center\">后天的</td>\n" +
            "  <td align=\"center\">大后天</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "  <td align=\"center\">{dw1}</td>\n" +
            "  <td align=\"center\">{dw2}</td>\n" +
            "  <td align=\"center\">{dw3}</td>\n" +
            "  <td align=\"center\">{dw4}</td>\n" +
            "  <td align=\"center\">{dw5}</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "  <td align=\"center\"><img hight=30 width=30 src=\"{dc1}\"/></td>\n" +
            "  <td align=\"center\"><img hight=30 width=30 src=\"{dc1}\"/></td>\n" +
            "  <td align=\"center\"><img hight=30 width=30 src=\"{dc1}\"/></td>\n" +
            "  <td align=\"center\"><img hight=30 width=30 src=\"{dc1}\"/></td>\n" +
            "  <td align=\"center\"><img hight=30 width=30 src=\"{dc1}\"/></td>\n" +
            "</tr>\n" +
            "<br><br>\n" +
            "<tr>\n" +
            "  <td align=\"center\">{dd1}°</td>\n" +
            "  <td align=\"center\">{dd2}°</td>\n" +
            "  <td align=\"center\">{dd3}°</td>\n" +
            "  <td align=\"center\">{dd4}°</td>\n" +
            "  <td align=\"center\">{dd5}°</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "  <td align=\"center\">{nd1}°</td>\n" +
            "  <td align=\"center\">{nd2}°</td>\n" +
            "  <td align=\"center\">{nd3}°</td>\n" +
            "  <td align=\"center\">{nd4}°</td>\n" +
            "  <td align=\"center\">{nd5}°</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "  <td align=\"center\"><img hight=30 width=30 src=\"{nc1}\"/></td>\n" +
            "  <td align=\"center\"><img hight=30 width=30 src=\"{nc2}\"/></td>\n" +
            "  <td align=\"center\"><img hight=30 width=30 src=\"{nc3}\"/></td>\n" +
            "  <td align=\"center\"><img hight=30 width=30 src=\"{nc4}\"/></td>\n" +
            "  <td align=\"center\"><img hight=30 width=30 src=\"{nc5}\"/></td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "  <td align=\"center\">{nw1}</td>\n" +
            "  <td align=\"center\">{nw2}</td>\n" +
            "  <td align=\"center\">{nw3}</td>\n" +
            "  <td align=\"center\">{nw4}</td>\n" +
            "  <td align=\"center\">{nw5}</td>\n" +
            "</tr>\n" +
            "\n" +
            "</table>\n" +
            "<br><br>\n" +
            "<br><br>\n" +
            "<img style=\"width=100%\" src=\"{oneImg}\"/>\n" +
            "</div>\n" +
            "<h5>{oneContent}</h5>\n" +
            "<h5 align=\"right\"> Data provided by Tencent & ONE</h5>\n" +
            "<h5 align=\"right\">From Your Piggy\uD83D\uDC37</h5>" +
            "</body>\n" +
            "</html>\n";

}