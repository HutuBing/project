package com.ljb.sbdemo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {
    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);
    public static final String DF_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    public static final String DF_yyyy_MM_dd_HH_mm_ss_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DF_yyyy_MM_dd = "yyyy-MM-dd";
    public static final String DF_yyyy_MM_dd2 = "yyyy年MM月dd日";
    public static final String DF_HH_mm_ss = "HH:mm:ss";
    public static final String DF_MM_dd = "MM-dd";
    public static final String DF_HH_mm_ss_SSS = "HH:mm:ss.SSS";
    public static final String DF_yyyyMM = "yyyyMM";
    public static final String DF_yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
    public static final String DF_yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static final String DF_MM_dd_HH_mm = "MM-dd HH:mm";
    public static final String DF_yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";
    public static final String DF_yyyy_MM_dd_HH_mm2 = "yyyy年MM月dd日 HH:mm";
    public static final String DF_yyyy_MM_dd_HH_mm3 = "yyyy年MM月dd日 HH:mm:ss";
    public static final String DF_MM_dd2 = "MM月dd日";

    public DateUtils() {
    }

    public static int getUnixTimeStamp() {
        return (int)(System.currentTimeMillis() / 1000L);
    }

    public static List<Date> getDateListbetweenDate(Date start, Date end) {
        List<Date> lDate = new ArrayList();
        lDate.add(start);
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(start);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(end);

        while(end.after(calBegin.getTime())) {
            calBegin.add(5, 1);
            Date time = calBegin.getTime();
            if (!lDate.contains(time)) {
                lDate.add(time);
            }
        }

        return lDate;
    }

    public static Object getWeekName(int dayOfWeek) {
        if (2 == dayOfWeek) {
            return "星期一";
        } else if (3 == dayOfWeek) {
            return "星期二";
        } else if (4 == dayOfWeek) {
            return "星期三";
        } else if (5 == dayOfWeek) {
            return "星期四";
        } else if (6 == dayOfWeek) {
            return "星期五";
        } else if (7 == dayOfWeek) {
            return "星期六";
        } else {
            return 1 == dayOfWeek ? "星期日" : "日期错误";
        }
    }

    public static String getWeekDay(Date date) {
        String[] weekDays = new String[]{"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int week = calendar.get(7) - 1;
        if (week < 0) {
            week = 0;
        }

        return weekDays[week];
    }

    public static Date dateString2Date(String dateStr, String datePatten) {
        SimpleDateFormat format = new SimpleDateFormat(datePatten);

        try {
            Date date = format.parse(dateStr);
            return date;
        } catch (ParseException var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static String date2Str(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static String timestamp2Dayweek(Integer timestamp) {
        GregorianCalendar cal = new GregorianCalendar();
        long time = (long)timestamp;
        cal.setTime(new Date(time * 1000L));
        int dow = cal.get(7);
        System.out.println(timestamp * 1000 + "---------dayWeek-----" + dow);
        switch(dow) {
            case 1:
                return "周日";
            case 2:
                return "周一";
            case 3:
                return "周二";
            case 4:
                return "周三";
            case 5:
                return "周四";
            case 6:
                return "周五";
            case 7:
                return "周六";
            default:
                return "Unknown";
        }
    }

    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0) {
            return "00:00";
        } else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99) {
                    return "99:59:59";
                }

                minute %= 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }

            return timeStr;
        }
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10) {
            retStr = "0" + Integer.toString(i);
        } else {
            retStr = "" + i;
        }

        return retStr;
    }

    public static String unixTimeStampInteger2DateString(Integer timeStamp, String format) {
        long l = (long)timeStamp * 1000L;
        SimpleDateFormat datetimefmt = new SimpleDateFormat(format);
        Date date = new Date(l);
        String retStr = datetimefmt.format(date);
        return retStr;
    }

    public static String unixTimeStampLong2DateString(Long timeStamp, String format) {
        SimpleDateFormat datetimefmt = new SimpleDateFormat(format);
        Date date = new Date(timeStamp);
        String retStr = datetimefmt.format(date);
        return retStr;
    }

    public static String timeStampToHourString(Integer timeStamp) {
        long l = (long)timeStamp * 1000L;
        SimpleDateFormat datetimefmt = new SimpleDateFormat("HH:mma", Locale.ENGLISH);
        Date date = new Date(l);
        String retStr = datetimefmt.format(date).toLowerCase();
        return retStr;
    }

    public static Date unixTimeStampInteger2Date(Integer timeStamp) {
        long l = (long)timeStamp * 1000L;
        Date date = new Date(l);
        return date;
    }

    public static Date unixDataStringToDate(String dataString, String format) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date parsedDate = dateFormat.parse(dataString);
        return parsedDate;
    }

    public static Integer differSecond(Date d1, Date d2) {
        if (d1 != null && d2 != null) {
            int second = (int)((d1.getTime() - d2.getTime()) / 1000L);
            return second < 0 ? -second : second;
        } else {
            return 0;
        }
    }

    public static Integer differMinuteUp(Date d1, Date d2) {
        if (d1 != null && d2 != null) {
            long time = d1.getTime() - d2.getTime();
            time = time < 0L ? -time : time;
            double second = (double)(time / 1000L);
            return (int)Math.ceil(second / 60.0D);
        } else {
            return 0;
        }
    }

    public static Integer differMinuteDown(Date d1, Date d2) {
        if (d1 != null && d2 != null) {
            long time = d1.getTime() - d2.getTime();
            time = time < 0L ? -time : time;
            int second = (int)(time / 1000L);
            return second / 60;
        } else {
            return 0;
        }
    }

    public static Date max(Date d1, Date d2) {
        if (d1 == null && d2 == null) {
            return null;
        } else if (d1 == null) {
            return d2;
        } else if (d2 == null) {
            return d1;
        } else {
            return d1.after(d2) ? d1 : d2;
        }
    }

    public static Date min(Date d1, Date d2) {
        if (d1 == null && d2 == null) {
            return null;
        } else if (d1 == null) {
            return d2;
        } else if (d2 == null) {
            return d1;
        } else {
            return d1.before(d2) ? d1 : d2;
        }
    }

    public static Date turnStrDateToJavaUtilDate(String strDate, String dateFormatType) {
        Date javaUtilDate = null;
        DateFormat df = new SimpleDateFormat(dateFormatType);
        if (strDate != null && !"".equals(strDate) && dateFormatType != null && !"".equals(dateFormatType)) {
            try {
                javaUtilDate = df.parse(strDate);
            } catch (ParseException var5) {
                logger.error(var5.getMessage());
            }
        }

        return javaUtilDate;
    }
}
