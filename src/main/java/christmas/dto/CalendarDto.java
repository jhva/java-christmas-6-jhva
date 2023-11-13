package christmas.dto;

import christmas.constant.CalendarType;
import christmas.model.Calendar;

public record CalendarDto(boolean isWeekday, CalendarType calendarType, boolean isWeekend, boolean isSpecial,
                          int christmasCount) {

    public static CalendarDto fromCalendar(Calendar calendar) {
        return new CalendarDto(
                calendar.isWeekday(),
                calendar.getToday(),
                calendar.isWeekend(),
                calendar.isSpecialDay(),
                calendar.getChristmasCount()
        );
    }
}
