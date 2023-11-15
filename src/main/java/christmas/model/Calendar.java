package christmas.model;

import static christmas.constant.ChristmasConst.CHRISTMAS_DAY;
import static christmas.constant.ChristmasConst.CHRISTMAS_DAY_AFTER_NOT_DISCOUNT;
import static christmas.constant.ChristmasConst.CHRISTMAS_MAX_DISCOUNT;
import static christmas.constant.ChristmasConst.INCREMENT_PRICE;
import static christmas.constant.ChristmasConst.ONE_DAY_MINUS_MONTH;
import static christmas.constant.ChristmasConst.ORIGIN_MONTH;
import static christmas.constant.ChristmasConst.START_OF_CHRISTMAS_BASIC_PRICE;
import static christmas.constant.ChristmasConst.TODAY;
import static christmas.constant.ChristmasConst.WEEK;
import static christmas.exception.Validator.validateDay;

import christmas.constant.CalendarType;

public class Calendar {

    private static boolean isWeekend;

    private boolean isWeekday;

    private boolean isSpecial;

    private int christmasCount;

    private CalendarType calenderType;

    public Calendar(int day) {
        int validateDay = validateDay(day);
        calculateToday(validateDay);
        calculateChristmasEventTotalDiscountAmount(validateDay);
        validateIsWeekDayOrIsWeekend(validateDay);
        validChristmasDiscount();
    }


    private void calculateToday(int day) {
        CalendarType[] cal = CalendarType.values();
        this.calenderType = cal[(day % WEEK) - TODAY];
    }

    private void calculateChristmasEventTotalDiscountAmount(int today) {
        this.christmasCount =
                START_OF_CHRISTMAS_BASIC_PRICE + (ONE_DAY_MINUS_MONTH * INCREMENT_PRICE)
                        - (ORIGIN_MONTH - today) * INCREMENT_PRICE;
    }

    private void validChristmasDiscount() {
        if (this.christmasCount >= CHRISTMAS_MAX_DISCOUNT) {
            christmasCount = CHRISTMAS_DAY_AFTER_NOT_DISCOUNT;
        }
    }

    private void validateIsWeekDayOrIsWeekend(int day) {
        if (calenderType.equals(CalendarType.FRIDAY) || calenderType.equals(CalendarType.SATURDAY)) {
            isWeekend = true;
        }
        if (calenderType.equals(CalendarType.SUNDAY) || day == CHRISTMAS_DAY) {
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
