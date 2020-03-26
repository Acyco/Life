package cn.acyco.life.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间处理工具类 大部分参考https://www.cnblogs.com/wader2011/archive/2011/12/02/2271981.html这个页面
 *
 * @author Acyco
 * @create 2020-03-26 08:18
 */
public class TimeUtil {
    private static final int YEAR = 365 * 24 * 60 * 60;// 一年所有的秒数
    private static final int MONTH = 30 * 24 * 60 * 60;// 一月所有的秒数
    private static final int DAY = 24 * 60 * 60;// 一天所有的秒数
    private static final int HOUR = 60 * 60;// 一小时所有的秒数
    private static final int MINUTE = 60;// 一分钟所有的秒数
    private static SimpleDateFormat SDF = new SimpleDateFormat();

    /**
     * 根据时间戳获取描述性时间(单位：毫秒)
     *
     * @param timestamp 时间戳 毫秒
     * @return          时间字符串
     */
    public static String getDescriptionTimeFromTimestampMS(long timestamp) {
        //计算出当时时间与传递参数的时间差 并转换成秒数
        long timeGap = (System.currentTimeMillis() - timestamp) / 1_000;
        String timeStr = "";
        if (timeGap > YEAR) {
            timeStr = timeGap / YEAR + "年前";
        } else if (timeGap > MONTH) {
            timeStr = timeGap / MONTH + "个月前";
        } else if (timeGap > 7 * DAY) {// 一星期以上
            timeStr = "一星期前";
        } else if (timeGap > DAY) {// 1天以上
            timeStr = timeGap / DAY + "天前";
        } else if (timeGap > HOUR) {// 1小时-24小时
            timeStr = timeGap / HOUR + "小时前";
        } else if (timeGap > MINUTE) {// 1分钟-59分钟
            timeStr = timeGap / MINUTE + "分钟前";
        } else {// 1秒钟-59秒钟
            timeStr = "刚刚";
        }
        return timeStr;
    }

    /**
     * 根据时间戳获取描述性时间 (单位：秒)
     *
     * @param timestamp     时间戳 秒
     * @return              时间字符串
     */
    public static String getDescriptionTimeFromTimestampS(long timestamp) {
        return getDescriptionTimeFromTimestampMS((timestamp * 1_000));
    }

    /**
     * 据时间戳获取指定格式的时间 例如：2020-03-26 09:20:25
     *
     * @param timestamp     时间戳
     * @param format_type   时间格式化类型 枚举
     * @return              时间字符串
     */

    public static String getFormatTimeFromTimestamp(long timestamp, TIME_FORMAT_TYPE format_type) {
        return getFormatTimeFromTimestamp(timestamp, format_type.getFormat());
    }

    /**
     * 据时间戳获取指定格式的时间 例如：2020-03-26 09:20:25
     *
     * @param timestamp 时间戳
     * @param format    时间格式化类型 字符串
     * @return          时间字符串
     */
    public static String getFormatTimeFromTimestamp(long timestamp, String format) {
        if (format == null || format.trim().equals("")) {
            SDF.applyPattern(TIME_FORMAT_TYPE.FORMAT_DATE.getFormat());

        } else {
            SDF.applyPattern(format);

        }
        return SDF.format(new Date(timestamp));
    }
    
    /**
     * 根据时间戳获取时间字符串，并根据指定的时间分割数partionSeconds来自动判断返回描述性时间还是指定格式的时间
     *
     * @param timestamp      时间戳 毫秒
     * @param partionSeconds 指定的时间分割数
     * @param format_type    时间格式化类型 枚举
     * @return               时间字符串
     */
    public static String getMixTimeFromTimestamp(long timestamp, long partionSeconds, TIME_FORMAT_TYPE format_type) {
        return getMixTimeFromTimestamp(timestamp, partionSeconds, format_type.getFormat());
    }

    /**
     * 根据时间戳获取时间字符串，并根据指定的时间分割数partionSeconds来自动判断返回描述性时间还是指定格式的时间
     *
     * @param timestamp      时间戳 毫秒
     * @param partionSeconds 指定的时间分割数
     * @param format         格式化  字符串
     * @return               时间字符串
     */
    public static String getMixTimeFromTimestamp(long timestamp, long partionSeconds, String format) {
        long timeGap = (System.currentTimeMillis() - timestamp) / 1000;// 与现在时间相差秒数
        if (timeGap <= partionSeconds) {
            return getDescriptionTimeFromTimestampMS(timestamp);
        } else {
            return getFormatTimeFromTimestamp(timestamp, format);
        }
    }

    /**
     * 获取当前日期的指定格式的字符串
     *
     * @param format_type   指定的日期时间格式  枚举
     * @return              时间字符串
     */
    public static String getCurrentTime(TIME_FORMAT_TYPE format_type) {
        if(format_type==null) format_type = TIME_FORMAT_TYPE.FORMAT_DATE_TIME;
        return getCurrentTime(format_type.getFormat());
    }

    /**
     * 获取当前日期的指定格式的字符串
     *
     * @param format 指定的日期时间格式，若为null或""则使用指定的格式"yyyy-MM-dd HH:MM"
     * @return       时间字符串
     */
    public static String getCurrentTime(String format) {
        if (format == null || format.trim().equals("")) {
            SDF.applyPattern(TIME_FORMAT_TYPE.FORMAT_DATE_TIME.getFormat());
        } else {
            SDF.applyPattern(format);
        }
        return SDF.format(new Date());
    }

    /**
     * 将日期字符串以指定格式转换为Date
     * @param timeStr       日期字符串
     * @param format_type   指定的日期格式
     * @return              日期 Date
     */
    public static Date getTimeFromString(String timeStr, TIME_FORMAT_TYPE format_type) {
        if(format_type==null) format_type = TIME_FORMAT_TYPE.FORMAT_DATE_TIME;
        return getTimeFromString(timeStr, format_type.getFormat());
    }

    /**
     * 将日期字符串以指定格式转换为Date
     * @param timeStr   日期字符串
     * @param format    指定的日期格式，若为null或""则使用指定的格式"yyyy-MM-dd HH:MM"
     * @return          日期 Date
     */
    public static Date getTimeFromString(String timeStr, String format) {
        if (format == null || format.trim().equals("")) {
            SDF.applyPattern(TIME_FORMAT_TYPE.FORMAT_DATE_TIME.getFormat());
        } else {
            SDF.applyPattern(format);
        }
        try {
            return SDF.parse(timeStr);
        } catch (ParseException e) {
            return new Date();
        }
    }

    /**
     * 将Date以指定格式转换为日期时间字符串
     * @param date
     * @param format_type
     * @return
     */
    public static String getStringFromTime(Date date, TIME_FORMAT_TYPE format_type) {
        if(format_type==null) format_type = TIME_FORMAT_TYPE.FORMAT_DATE_TIME;
        return getStringFromTime(date, format_type.getFormat()); 
    }
    
    /**
     * 将Date以指定格式转换为日期时间字符串
     * @param date    日期
     * @param format  指定的日期时间格式，若为null或""则使用指定的格式"yyyy-MM-dd HH:MM"
     * @return        时间字符串
     */
    public static String getStringFromTime(Date date, String format) {
        if (format == null || format.trim().equals("")) {
            SDF.applyPattern(TIME_FORMAT_TYPE.FORMAT_DATE_TIME.getFormat());
        } else {
            SDF.applyPattern(format);
        }
        return SDF.format(date);
    }

    
    

    public static enum TIME_FORMAT_TYPE { //时间格式化类型
        FORMAT_DATE("yyyy-MM-dd"), //2020-03-26
        FORMAT_TIME("hh:mm"),   //08:55
        FORMAT_DATE_TIME("yyyy-MM-dd hh:mm"),//2020-03-26 08:55
        FORMAT_DATE_TIME_SEC("yyyy-MM-dd hh:mm:ss"),//2020-03-26 08:56:13
        FORMAT_MONTH_DAY_TIME("MM月dd日 hh:mm");  //03月26日  08:56

        private final String format;

        TIME_FORMAT_TYPE(String format) {
            this.format = format;
        }

        public String getFormat() {
            return format;
        }
    }
    
}
