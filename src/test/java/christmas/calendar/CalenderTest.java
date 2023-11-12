package christmas.calendar;

import christmas.constants.Calendar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalenderTest {

    @Test
    void input_으로_부터_받아온_날짜를_통해_요일을_계산한다() {
        int inputOfDay = 25;
        int week = 7;
        int todayInclude = 1;
        Calendar[] cal = Calendar.values();
        String expectedMonday = String.valueOf(cal[(inputOfDay % week) - todayInclude]);
        Assertions.assertEquals(expectedMonday, String.valueOf(Calendar.MONDAY));
    }
}
