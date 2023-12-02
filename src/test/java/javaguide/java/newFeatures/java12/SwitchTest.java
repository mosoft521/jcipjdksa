package javaguide.java.newFeatures.java12;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class SwitchTest {
    @Test
    public void switchTest() {
        LocalDate today = LocalDate.now();
        System.out.println(today);//2023-12-02
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        System.out.println(dayOfWeek);//SATURDAY
        switch (dayOfWeek) {
            case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
            case TUESDAY -> System.out.println(7);
            case THURSDAY, SATURDAY -> System.out.println(8);//8
            case WEDNESDAY -> System.out.println(9);
        }
    }
}