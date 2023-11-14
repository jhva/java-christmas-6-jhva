package christmas.dto;

import christmas.model.TotalDiscountMenu;

public record TotalDiscountMenuDto(int totalDiscountAmount, int weekdayAmount, int weekendAmount, int specialAmount,
                                   int presentationAmount) {

    public static TotalDiscountMenuDto fromTotalDiscountMenu(TotalDiscountMenu totalDiscountMenu) {
        return new TotalDiscountMenuDto(
                totalDiscountMenu.getTotalDiscountAmount(),
                totalDiscountMenu.getWeekdayAmount(),
                totalDiscountMenu.getWeekendAmount(),
                totalDiscountMenu.getSpecialAmount(),
                totalDiscountMenu.getPresentationAmount()
        );
    }
}