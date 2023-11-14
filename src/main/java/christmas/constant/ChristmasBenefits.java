package christmas.constant;

import christmas.model.TotalDiscountMenu;

public enum ChristmasBenefits {

    CHRISTMAS("크리스마스 디데이 할인: -%s원", 0, 0),
    WEEK("평일 할인: -%s원", 0, 0),
    WEEKEND("주말 할인: -%s원", 0, 0),
    SPECIAL("특별 할인: -%s원", 0, 0),
    GIVEN("증정 이벤트: -%s원", 0, 0);

    ChristmasBenefits(String message, int counter, int price) {
        this.counter = counter;
        this.message = message;
        this.price = price;
    }

    private int counter;
    private String message;
    private int price;

    public void updateDiscountCounters(TotalDiscountMenu totalDiscountMenu, int christmasDiscount) {
        ChristmasBenefits.CHRISTMAS.incrementCounter(christmasDiscount, christmasDiscount);
        ChristmasBenefits.WEEK.incrementCounter(totalDiscountMenu.getWeekdayAmount(),
                totalDiscountMenu.getWeekdayAmount());
        ChristmasBenefits.WEEKEND.incrementCounter(totalDiscountMenu.getWeekendAmount(),
                totalDiscountMenu.getWeekendAmount());
        ChristmasBenefits.SPECIAL.incrementCounter(totalDiscountMenu.getSpecialAmount(),
                totalDiscountMenu.getSpecialAmount());
        ChristmasBenefits.GIVEN.incrementCounter(totalDiscountMenu.getPresentationAmount(),
                totalDiscountMenu.getPresentationAmount());
    }

    public void incrementCounter(int type, int price) {
        if (type > 0) {
            this.counter++;
            this.price = price;
        }
    }

    public int getPrice() {
        return price;
    }

    public int getCounter() {
        return counter;
    }

    public String getMessage() {
        return message;
    }
}
