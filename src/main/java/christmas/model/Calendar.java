package christmas.model;

import christmas.constants.CalendarType;

public class Calendar {

    private boolean weekend;

    private boolean weekday;

    private boolean specialDay;

    private CalendarType calenderType;

    public Calendar(int day) {
        calculateToday(day);
        isWeekday(day);
        isWeekend(day);
        isSpecialDay(day);
    }

    public void calculateToday(int day) {
        CalendarType[] cal = CalendarType.values();
        this.calenderType = cal[(day % 7) - 1];
    }

    public CalendarType getToday() {
        return calenderType;
    }

    public void isWeekend(int day) {
    }

    public void isWeekday(int day) {
    }

    public void isSpecialDay(int day) {
    }
}
