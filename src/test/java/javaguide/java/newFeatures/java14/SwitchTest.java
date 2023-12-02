package javaguide.java.newFeatures.java14;

import org.junit.jupiter.api.Test;

public class SwitchTest {
    @Test
    public void switchTest() {
        String day = "SU";
        String result = switch (day) {
            case "M", "W", "F" -> "MWF";
            case "T", "TH", "S" -> "TTS";
            default -> {
                if (day.isEmpty())
                    yield "Please insert a valid day.";
                else
                    yield "Looks like a Sunday.";
            }

        };
        System.out.println(result);//Looks like a Sunday.
    }
}