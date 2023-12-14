package org.apache.commons.lang3;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTest {
    @Test
    public void str2DateTest() throws ParseException {
        final String strDate = "2021-07-04 11:11:11";
        final String pattern = "yyyy-MM-dd HH:mm:ss";
        // 原生写法
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date1 = sdf.parse(strDate);
        System.out.println(date1);//Sun Jul 04 11:11:11 CST 2021
        // commons写法
        Date date2 = DateUtils.parseDate(strDate, pattern);
        System.out.println(date2);//Sun Jul 04 11:11:11 CST 2021
    }

    @Test
    public void date2StrTest() {
        final Date date = new Date();
        final String pattern = "yyyy年MM月dd日";
        // 原生写法
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String strDate = sdf.format(date);
        System.out.println(strDate);//2023年12月14日
        // 使用commons写法
        String strDate2 = DateFormatUtils.format(date, pattern);
        System.out.println(strDate2);//2023年12月14日
    }

    @Test
    public void dateCalcTest() {
        final Date date = new Date();
        // 原生写法
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        System.out.println(date);//Thu Dec 14 08:34:55 CST 2023
        cal.add(Calendar.DATE, 5); // 加5天
        System.out.println(cal.getTime());//Tue Dec 19 08:34:55 CST 2023
        cal.add(Calendar.HOUR_OF_DAY, -5); // 减5小时
        System.out.println(cal.getTime());//Tue Dec 19 03:34:55 CST 2023
        // 使用commons写法
        Date newDate1 = DateUtils.addDays(date, 5); // 加5天
        System.out.println(newDate1);//Tue Dec 19 08:34:55 CST 2023
        Date newDate2 = DateUtils.addHours(date, -5); // 减5小时
        System.out.println(newDate2);//Thu Dec 14 03:34:55 CST 2023
        Date newDate3 = DateUtils.truncate(date, Calendar.DATE); // 过滤时分秒
        System.out.println(newDate3);//Thu Dec 14 00:00:00 CST 2023
        boolean isSameDay = DateUtils.isSameDay(newDate1, newDate2); // 判断是否是同一天
        System.out.println(isSameDay);//false
    }
}
