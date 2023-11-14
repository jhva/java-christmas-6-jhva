package christmas.model;

import christmas.constant.MenuType;
import java.util.Objects;

public class TotalDiscountMenu {

    private int totalDiscountAmount;

    private int weekdayAmount;

    private int weekendAmount;

    private int specialAmount;

    private int presentationAmount;

    public TotalDiscountMenu(boolean isWeekend, boolean isWeekday, boolean isSpecial, int quantity, boolean isGiven,
            String menuType) {
        calculateDiscount(isWeekend, isWeekday, isSpecial, quantity, menuType);
        calculateTotalDiscount();
        calculateIsPresentation(isGiven);
    }

    public void calculateIsPresentation(boolean isPresentation) {
        if (isPresentation) {
            presentationAmount = 25000;
        }
    }

    private void calculateTotalDiscount() {
        totalDiscountAmount = weekdayAmount + weekendAmount + specialAmount + presentationAmount;
    }

    public void calculateDiscount(boolean isWeekend, boolean isWeekday, boolean isSpecial, int quantity,
            String menuType) {
        if (isWeekday && Objects.equals(menuType, MenuType.DESSERT.name())) {
            this.weekdayAmount += quantity * 2023;
        }
        if (isWeekend && Objects.equals(menuType, MenuType.MAIN.name())) {
            this.weekendAmount += quantity * 2023;
        }
        if (isSpecial) {
            this.specialAmount = 1000;
        }
    }

    public int getPresentationAmount() {
        return presentationAmount;
    }

    public int getTotalDiscountAmount() {
        return totalDiscountAmount;
    }

    public int getWeekdayAmount() {
        return weekdayAmount;
    }

    public int getWeekendAmount() {
        return weekendAmount;
    }

    public int getSpecialAmount() {
        return specialAmount;
    }
}
