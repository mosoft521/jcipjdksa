package javaguide.java.newFeatures.modern;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class DateTest {
    @Test
    public void clockTest() {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);//1701461544517
        Instant instant = clock.instant();
        System.out.println(instant);
        Date legacyDate = Date.from(instant); //2023-12-01T20:12:24.517Z
        System.out.println(legacyDate);//Sat Dec 02 04:12:24 CST 2023
    }

    @Test
    public void timezoneTest() {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);//1701461544517
        Instant instant = clock.instant();
        System.out.println(instant);
        Date legacyDate = Date.from(instant); //2023-12-01T20:12:24.517Z
        System.out.println(legacyDate);//Sat Dec 02 04:12:24 CST 2023
    }

    @Test
    public void localTimeTest() {
        ZoneId zone1 = ZoneId.of(ZoneId.SHORT_IDS.get("CTT"));//Asia/Shanghai
        ZoneId zone2 = ZoneId.of(ZoneId.SHORT_IDS.get("JST"));//Asia/Tokyo
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        System.out.println(now1.isBefore(now2)); // true
        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
        System.out.println(hoursBetween); // 1
        System.out.println(minutesBetween); // 60
    }

    @Test
    public void localTimeTest2() {
        LocalTime late = LocalTime.of(23, 59, 59);
        System.out.println(late);       // 23:59:59
        DateTimeFormatter germanFormatter =
                DateTimeFormatter
                        .ofLocalizedTime(FormatStyle.SHORT)
                        .withLocale(Locale.GERMAN);
        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        System.out.println(leetTime);   // 13:37
    }

    @Test
    public void localDateTest() {
        LocalDate today = LocalDate.now();//获取现在的日期
        System.out.println("今天的日期: " + today);//今天的日期: 2023-12-02
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        System.out.println("明天的日期: " + tomorrow);//明天的日期: 2023-12-03
        LocalDate yesterday = tomorrow.minusDays(2);
        System.out.println("昨天的日期: " + yesterday);//昨天的日期: 2023-12-01
        LocalDate independenceDay = LocalDate.of(2023, Month.DECEMBER, 2);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println("今天是周几:" + dayOfWeek);//今天是周几:SATURDAY
    }

    @Test
    public void localDateTimeTest() {
        String str1 = "2023==12==02 01时06分09秒";
        // 根据需要解析的日期、时间字符串定义解析所用的格式器
        DateTimeFormatter fomatter1 = DateTimeFormatter
                .ofPattern("yyyy==MM==dd HH时mm分ss秒");
        LocalDateTime dt1 = LocalDateTime.parse(str1, fomatter1);
        System.out.println(dt1); // 2023-12-02T01:06:09
        String str2 = "2023$$$十二月$$$13 20小时";
        DateTimeFormatter fomatter2 = DateTimeFormatter
                .ofPattern("yyy$$$MMM$$$dd HH小时");
        LocalDateTime dt2 = LocalDateTime.parse(str2, fomatter2);
        System.out.println(dt2); // 2023-12-13T20:00
    }

    @Test
    public void dateTimeFormatterTest() {
        LocalDateTime rightNow = LocalDateTime.now();
        String date = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(rightNow);
        System.out.println(date);//2023-12-02T04:43:45.007
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        System.out.println(formatter.format(rightNow));//2023-12-02 04:43:45
    }

    @Test
    public void dateTimeFormatterTest2() {
        LocalDateTime rightNow = LocalDateTime.of(2023, 12, 31, 12, 0, 0);
        String date = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(rightNow);// 2023-12-31T12:00:00
        System.out.println(date);
        DateTimeFormatter formatterOfYYYY = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        System.out.println(formatterOfYYYY.format(rightNow));// todo:err 2024-12-31 12:00:00
        DateTimeFormatter formatterOfYyyy = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatterOfYyyy.format(rightNow));// 2023-12-31 12:00:00
    }

    @Test
    public void localDateTimeTest2() {
        LocalDateTime sylvester = LocalDateTime.of(2023, Month.DECEMBER, 2, 23, 59, 59);
        DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
        System.out.println(dayOfWeek); // SATURDAY
        Month month = sylvester.getMonth();
        System.out.println(month); // DECEMBER
        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay); // 1439
    }

    @Test
    public void localDateTime2Instant2DateTest() {
        LocalDateTime sylvester = LocalDateTime.of(2023, Month.DECEMBER, 2, 23, 59, 59);
        Instant instant = sylvester
                .atZone(ZoneId.systemDefault())
                .toInstant();
        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate); // Sat Dec 02 23:59:59 CST 2023
    }

    @Test
    public void localDateTimeDateTimeFormatterTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");
        LocalDateTime parsed = LocalDateTime.parse("十二月 03, 2023 - 07:13", formatter);
        String string = formatter.format(parsed);
        System.out.println(string); // 十二月 03, 2023 - 07:13
    }
}
