package javaguide.java.newFeatures.java21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StringTemplatesTest {
    private String name = "LokeshField";

    private static String getName() {
        return "LokeshMethod";
    }

    @Test
    public void test01() {
        String name = "Lokesh";
        String message;
        //variable
        message = STR. "Greetings \{ name }!" ;
        Assertions.assertEquals("Greetings Lokesh!", message);

        //method
        message = STR. "Greetings \{ getName() }!" ;
        Assertions.assertEquals("Greetings LokeshMethod!", message);

        //field
        message = STR. "Greetings \{ this.name }!" ;
        Assertions.assertEquals("Greetings LokeshField!", message);
    }

    @Test
    public void test02() {
        int x = 10, y = 20;
        String s = STR. "\{ x } + \{ y } = \{ x + y }" ;
        Assertions.assertEquals("10 + 20 = 30", s);
    }

    @Test
    public void test03() {
        LocalTime now = LocalTime.now();
        System.out.println(now);//05:27:44.452881900
        String time = STR. "The current time is \{
                //sample comment - current time in HH:mm:ss
                DateTimeFormatter.ofPattern("HH:mm:ss").format(now)
                }." ;
        Assertions.assertEquals("The current time is " + DateTimeFormatter.ofPattern("HH:mm:ss").format(now) + ".", time);
    }
}