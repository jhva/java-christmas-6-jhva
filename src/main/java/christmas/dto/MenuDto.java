package christmas.dto;

import christmas.model.Menu;

public record MenuDto(String menuName, int menuPrice, int menuQuantity, String menuType) {

    public static MenuDto fromMenu(Menu menu) {
        return new MenuDto(
                menu.getMenuName(),
                menu.getMenuPrice(),
                menu.getMenuQuantity(),
                menu.getMenuType()
        );
    }
}
