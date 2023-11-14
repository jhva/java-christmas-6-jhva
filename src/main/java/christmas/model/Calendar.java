package christmas.model;

import christmas.constant.CalendarType;

public class Calendar {

    private boolean isWeekend;

    private boolean isWeekday;

    private boolean isSpecial;

    private int christmasCount;

    private CalendarType calenderType;

    public Calendar(int day) {
        calculateToday(day);
        calculateChristmasEventTotalDiscountAmount(day);
        validateIsWeekDayOrIsWeekend(day);
    }


    private void calculateToday(int day) {
        CalendarType[] cal = CalendarType.values();
        this.calenderType = cal[(day % 7) - 1];
    }

    private void calculateChristmasEventTotalDiscountAmount(int today) {
        int incrementPrice = 100;
        int startOfChristmasBasicPrice = 1000;
        int oneDayMinusMonth = 30;
        int originMonth = 31;
        this.christmasCount =
                startOfChristmasBasicPrice + (oneDayMinusMonth * incrementPrice)
                        - (originMonth - today) * incrementPrice;
    }

    private void validateIsWeekDayOrIsWeekend(int day) {
        if (calenderType.equals(CalendarType.FRIDAY) || calenderType.equals(CalendarType.SATURDAY)) {
            this.isWeekend = true;
        }
        if (calenderType.equals(CalendarType.SUNDAY) && day == 25) {
            this.isSpecial = true;
        }
        this.isWeekday = true;
    }

    public CalendarType getToday() {
        return calenderType;
    }

    public int getChristmasCount() {
        return this.christmasCount;
    }

    public boolean isWeekend() {
        return this.isWeekend;
    }

    public boolean isWeekday() {
        return this.isWeekday;
    }

    public boolean isSpecialDay() {
        return this.isSpecial;
    }
}
