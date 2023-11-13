package christmas.calendar;

import christmas.constants.CalendarType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalenderTest {

    @Test
    void input_으로_부터_받아온_날짜를_통해_요일을_계산한다() {
        int inputOfDay = 25;
        int week = 7;
        int todayInclude = 1;

        CalendarType[] calendar = CalendarType.values();
        String expectedMonday = String.valueOf(calendar[(inputOfDay % week) - todayInclude]);

        Assertions.assertEquals(expectedMonday, String.valueOf(CalendarType.MONDAY));
    }

    @Test
    void 받아온_날짜_25일로_부터_크리스마스_디데이_할인_금액을_계산한다() {
        int incrementPrice = 100;
        int startOfChristmasBasicPrice = 1000;

        int inputOfDay = 25;

        int oneDayMinusMonth = 30;
        int originMonth = 31;

        int actualCalculate =
                startOfChristmasBasicPrice + (oneDayMinusMonth * incrementPrice)
                        - (originMonth - inputOfDay) * incrementPrice;

        int expectedTestOfChristmasEventPrice = 3400;

        Assertions.assertEquals(expectedTestOfChristmasEventPrice, actualCalculate);
    }
}
