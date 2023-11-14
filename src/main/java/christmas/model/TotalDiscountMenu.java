package christmas.model;

public class TotalDiscountMenu {

    private int totalDiscountAmount;

    private int weekdayAmount;

    private int weekendAmount;

    private int specialAmount;

    private int presentationAmount = 0;

    public TotalDiscountMenu(boolean isWeekend, boolean isWeekday, boolean isSpecial, int quantity) {
        calculateDiscount(isWeekend, isWeekday, isSpecial, quantity);
        calculateTotalDiscount();
        calculateIsPresentation();
    }

    private void calculateIsPresentation() {
        if (totalDiscountAmount >= 120000) {
            presentationAmount = 25000;
        }
    }

    private void calculateTotalDiscount() {
        totalDiscountAmount = weekdayAmount + weekendAmount + specialAmount;
    }

    public void calculateDiscount(boolean isWeekend, boolean isWeekday, boolean isSpecial, int quantity) {
        if (isWeekday) {
            this.weekdayAmount = quantity * 2023;
        }
        if (isWeekend) {
            this.weekendAmount = quantity * 2023;
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
