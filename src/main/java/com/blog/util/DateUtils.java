package com.blog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @function:
 * @Author: gaodawei
 * @Date: 2018/1/21 12:27
 */
public class DateUtils {

    public static final String LOG_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String SIMPLE_FORMAT = "yyyy-MM-dd";
    public static final String[] weekArray = new String[]{"星期日", "星期一",
            "星期二", "星期三", "星期四", "星期五", "星期六"};

    /**
     * 功能说明：将指定日期格式化成yyyy-MM-dd HH:mm:ss格式
     *
     * @param date 日期
     * @return String
     * @author liuli
     * @createTime 2017年2月27日下午12:06:19
     */
    public static String dateDefaultFormat(Date date) {
        if (date == null)
            return null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
        return dateFormat.format(date);
    }

    /**
     * 功能说明：将指定日期格式化成yyyy-MM-dd格式
     *
     * @param date 日期
     * @return String
     * @author liuli
     * @createTime 2017年2月27日下午12:06:19
     */
    public static String dateSimpleFormat(Date date) {
        if (date == null)
            return null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(SIMPLE_FORMAT);
        return dateFormat.format(date);
    }

    /**
     * 功能说明：将指定日期根据自定义格式化
     *
     * @param date   日期
     * @param format 格式化格式
     * @return String
     * @author liuli
     * @createTime 2017年2月27日下午12:08:01
     */
    public static String dateFormat(Date date, String format) {
        if (date == null)
            return null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * 功能说明：根据string类型的日期格式化成Date类型(yyyy-MM-dd HH:mm:ss)
     *
     * @param date
     * @return Date
     * @author liuli
     * @createTime 2017年2月27日下午12:10:54
     */
    public static Date stringToDefaultDateFormat(String date) {
        if (date != null && date.trim().length() == 0) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 功能说明：根据string类型的日期格式化成Date类型(yyyy-MM-dd)
     *
     * @param date
     * @return Date
     * @author liuli
     * @createTime 2017年2月27日下午12:10:54
     */
    public static Date stringToSimpleDateFormat(String date) {
        if (date != null && date.trim().length() == 0) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(SIMPLE_FORMAT);
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 功能说明：据string类型的日期格式化成指定格式的Date类型
     *
     * @param date   日期
     * @param format 日期格式
     * @return Date
     * @author liuli
     * @createTime 2017年2月27日下午12:13:42
     */
    public static Date stringToDateFormat(String date, String format) {
        if (date != null && date.trim().length() == 0) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(SIMPLE_FORMAT);
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 功能说明：根据指定日期获取指定日期当天是星期几
     *
     * @param date
     * @return
     * @author liuli
     * @createTime 2017年2月27日下午12:04:31
     */
    public static String getDayForWeek(Date date) {
        if (date == null)
            return null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayForWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayForWeek < 1) {
            return null;
        }
        return weekArray[dayForWeek - 1];
    }

    /**
     * 功能说明：将long型数据转换为string日期类型展示
     *
     * @param logTime 默认值：System.currentTimeMillis()
     * @return
     * @author gaodawei
     */
    public static String getLongToString(Long logTime) {
        SimpleDateFormat sdf = new SimpleDateFormat(LOG_FORMAT);
        if (logTime != null) {
            return sdf.format(logTime);
        } else {
            return sdf.format(System.currentTimeMillis());
        }
    }
}
