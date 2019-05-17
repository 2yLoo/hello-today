package com.yy.hellotoday.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 描述: 日期工具类
 *
 * @author 2yLoo
 * @create 2019-05-11 18:31
 */
public class DateUtil {

    private static final ThreadLocal<DateFormat> dateFormatForDay = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };


    private DateUtil() {
    }

    public static String genDate() {
        if (dateFormatForDay.get() == null) {
            dateFormatForDay.set(new SimpleDateFormat("yyyy-MM-dd"));
        }
        return dateFormatForDay.get().format(new Date());
    }

    public static int daysBetween(Date early, Date late) {
        Calendar calst = Calendar.getInstance();
        Calendar caled = Calendar.getInstance();
        calst.setTime(early);
        caled.setTime(late);
        //设置时间为0时
        calst.set(Calendar.HOUR_OF_DAY, 0);
        calst.set(Calendar.MINUTE, 0);
        calst.set(Calendar.SECOND, 0);
        caled.set(Calendar.HOUR_OF_DAY, 0);
        caled.set(Calendar.MINUTE, 0);
        caled.set(Calendar.SECOND, 0);
        //得到两个日期相差的天数
        int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst
                .getTime().getTime() / 1000)) / 3600 / 24;

        return days;
    }

    public static Date parseDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            System.out.println("日期解析异常");
        }
        return date;
    }

    public static int daysPerYearBetween(Date early, Date late) {
        Calendar calst = Calendar.getInstance();
        Calendar caled = Calendar.getInstance();
        calst.setTime(early);
        caled.setTime(late);
        //设置时间为0时
        calst.set(Calendar.YEAR, 0);
        calst.set(Calendar.HOUR_OF_DAY, 0);
        calst.set(Calendar.MINUTE, 0);
        calst.set(Calendar.SECOND, 0);
        caled.set(Calendar.YEAR, 0);

        caled.set(Calendar.HOUR_OF_DAY, 0);
        caled.set(Calendar.MINUTE, 0);
        caled.set(Calendar.SECOND, 0);
        //得到两个日期相差的天数
        int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst
                .getTime().getTime() / 1000)) / 3600 / 24;

        return days;
    }

}