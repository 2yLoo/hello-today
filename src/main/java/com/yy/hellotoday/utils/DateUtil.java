package com.yy.hellotoday.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述: 日期工具类
 *
 * @author yangyang.luo
 * @create 2019-05-11 18:31
 */
public class DateUtil {

    private static final ThreadLocal<DateFormat> dateFormatForDay = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };


    private DateUtil() {
    }

    public static String genDate(){
        if(dateFormatForDay.get() == null){
            dateFormatForDay.set(new SimpleDateFormat("yyyy-MM-dd"));
        }
        return dateFormatForDay.get().format(new Date());
    }
}