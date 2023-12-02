package javaguide.java.newFeatures;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeTest {
    @Test
    public void oldFormat() {
        Date now = new Date();
        //format yyyy-MM-dd
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(now);
        System.out.println(String.format("date format : %s", date));//date format : 2023-12-01

        //format HH:mm:ss
        SimpleDateFormat sdft = new SimpleDateFormat("HH:mm:ss");
        String time = sdft.format(now);
        System.out.println(String.format("time format : %s", time));//time format : 18:23:56

        //format yyyy-MM-dd HH:mm:ss
        SimpleDateFormat sdfdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = sdfdt.format(now);
        System.out.println(String.format("dateTime format : %s", datetime));//dateTime format : 2023-12-01 18:23:56
    }

    @Test
    public void newFormat() {
        //format yyyy-MM-dd
        LocalDate date = LocalDate.now();
        System.out.println(String.format("date format : %s", date));//date format : 2023-12-01

        //format HH:mm:ss
        LocalTime time = LocalTime.now().withNano(0);
        System.out.println(String.format("time format : %s", time));//time format : 18:25:44

        //format yyyy-MM-dd HH:mm:ss
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTimeStr = dateTime.format(dateTimeFormatter);
        System.out.println(String.format("dateTime format : %s", dateTimeStr));//dateTime format : 2023-12-01 18:25:44
    }

    @Test
    public void oldParse() throws ParseException {
        //已弃用
        // Date date = new Date("2021-01-26");
        //替换为
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("2021-01-26");
        System.out.println(date1);//Tue Jan 26 00:00:00 CST 2021
    }

    @Test
    public void newParse() {
        LocalDate date = LocalDate.parse("2021-01-26");
        System.out.println(date);//2021-01-26

        LocalDateTime dateTime = LocalDateTime.parse("2021-01-26T12:12:22");
        System.out.println(dateTime);//2021-01-26T12:12:22

        LocalTime time = LocalTime.parse("12:12:22");
        System.out.println(time);//12:12:22
    }

    @Test
    public void oldCalc() throws ParseException {
        //一周后的日期
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, 7);
        Date d = ca.getTime();
        String after = formatDate.format(d);
        System.out.println("一周后日期：" + after);//一周后日期：2023-12-08

        //算两个日期间隔多少天，计算间隔多少年，多少月方法类似
        String dates1 = "2024-02-10";
        String dates2 = "2023-12-01";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format.parse(dates1);
        Date date2 = format.parse(dates2);
        int day = (int) ((date1.getTime() - date2.getTime()) / (1000 * 3600 * 24));
        System.out.println(dates1 + "和" + dates2 + "相差" + day + "天");
        //结果：2024-02-10和2023-12-01相差71天
    }

    @Test
    public void newCalc() {
        //一周后的日期
        LocalDate localDate = LocalDate.now();
        //方法1
        LocalDate after = localDate.plus(1, ChronoUnit.WEEKS);
        System.out.println("一周后日期：" + after);//一周后日期：2023-12-08
        //方法2
        LocalDate after2 = localDate.plusWeeks(1);
        System.out.println("一周后日期：" + after2);//一周后日期：2023-12-08

        //算两个日期间隔多少天，计算间隔多少年，多少月
        LocalDate date1 = LocalDate.parse("2023-12-01");
        LocalDate date2 = LocalDate.parse("2024-02-10");
        Period period = Period.between(date1, date2);
        System.out.println("date1 到 date2 相隔：" + period.getYears() + "年" + period.getMonths() + "月" + period.getDays() + "天");
        //打印结果是 “date1 到 date2 相隔：0年2月9天”
        //这里period.getDays()得到的天是抛去年月以外的天数，并不是总天数
        //如果要获取纯粹的总天数应该用下面的方法
        long day = date2.toEpochDay() - date1.toEpochDay();
        System.out.println(date1 + "和" + date2 + "相差" + day + "天");
        //打印结果：2023-12-01和2024-02-10相差71天
    }

    @Test
    public void oldGetDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 1);
        String first = format.format(c.getTime());
        System.out.println("first day:" + first);//first day:2023-12-01

        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = format.format(ca.getTime());
        System.out.println("last day:" + last);//last day:2023-12-31

        //当年最后一天
        Calendar currCal = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, currCal.get(Calendar.YEAR));
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date time = calendar.getTime();
        System.out.println("last day:" + format.format(time));//last day:2023-12-31
    }

    @Test
    public void newGetDay() {
        LocalDate today = LocalDate.now();
        //获取当前月第一天：
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfThisMonth);//2023-12-01
        // 取本月最后一天
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayOfThisMonth);//2023-12-31
        //取下一天：
        LocalDate nextDay = lastDayOfThisMonth.plusDays(1);
        System.out.println(nextDay);//2024-01-01
        //当年最后一天
        LocalDate lastday = today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println(lastday);//2023-12-31
        //2023年最后一个周五，如果用Calendar是不得烦死。
        LocalDate lastMondayOf2023 = LocalDate.parse("2023-12-31").with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));
        System.out.println(lastMondayOf2023);//2023-12-29
    }

    @Test
    public void oldTimeZone() {
        //北京时间：Fri Dec 01 18:54:50 CST 2023
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //北京时区
        bjSdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        System.out.println("毫秒数:" + date.getTime() + ", 北京时间:" + bjSdf.format(date));
        // 毫秒数:1701428090876, 北京时间:2023-12-01 18:54:50

        //东京时区
        SimpleDateFormat tokyoSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tokyoSdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));  // 设置东京时区
        System.out.println("毫秒数:" + date.getTime() + ", 东京时间:" + tokyoSdf.format(date));
        // 毫秒数:1701428090876, 东京时间:2023-12-01 19:54:50

        //如果直接print会自动转成当前时区的时间
        System.out.println(date);
        //Fri Dec 01 18:54:50 CST 2023
    }

    @Test
    public void newTimeZone() {
        //当前时区时间
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("当前时区时间: " + zonedDateTime);
        //当前时区时间: 2023-12-01T18:56:44.597+08:00[Asia/Shanghai]

        //东京时间
        ZoneId zoneId = ZoneId.of(ZoneId.SHORT_IDS.get("JST"));
        ZonedDateTime tokyoTime = zonedDateTime.withZoneSameInstant(zoneId);
        System.out.println("东京时间: " + tokyoTime);
        //东京时间: 2023-12-01T19:56:44.597+09:00[Asia/Tokyo]

        // ZonedDateTime 转 LocalDateTime
        LocalDateTime localDateTime = tokyoTime.toLocalDateTime();
        System.out.println("东京时间转当地时间: " + localDateTime);
        //东京时间转当地时间: 2023-12-01T19:56:44.597

        //LocalDateTime 转 ZonedDateTime
        ZonedDateTime localZoned = localDateTime.atZone(ZoneId.systemDefault());
        System.out.println("本地时区时间: " + localZoned);
        //本地时区时间: 2023-12-01T19:56:44.597+08:00[Asia/Shanghai]
    }
}