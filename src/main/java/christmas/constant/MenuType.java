package christmas.constant;

import static christmas.exception.Validator.validatorQuantity;

import christmas.exception.ErrorMsg;
import christmas.exception.UserInputException;
import java.util.List;
import java.util.Map;

public enum MenuType {
    APPETIZER("애피타이저", List.of(Map.of("양송이수프", 5000), Map.of("타파스", 5500),
            Map.of("시저샐러드", 8000))),
    MAIN("메인", List.of(Map.of("티본스테이크", 55000), Map.of("바비큐립", 54000),
            Map.of("해산물파스타", 35000), Map.of("크리스마스파스타", 25000))),
    DESSERT("디저트", List.of(Map.of("초코케이크", 15000), Map.of("아이스크림", 5000))),
    BEVERAGE("음료", List.of(Map.of("제로콜라", 3000), Map.of("레드와인", 60000),
            Map.of("샴페인", 25000)));


    private final String getDisplayName;
    private final List<Map<String, Integer>> menus;

    MenuType(String getDisplayName, List<Map<String, Integer>> menus) {
        this.getDisplayName = getDisplayName;
        this.menus = menus;
    }

    public String getDisplayName() {
        return this.getDisplayName;
    }

    public int findMenuReturnTotalAmount(String menu, int quantity) {
        int totalAmount = 0;
        for (Map<String, Integer> menuMap : menus) {
            validatorQuantity(String.valueOf(quantity));
            validateMenuAndQuantityCheck(menuMap, menu, quantity);
            if (menuMap.containsKey(menu)) {
                int price = menuMap.get(menu);
                totalAmount += price * quantity;
            }

        }
        return totalAmount;
    }

    void validateMenuAndQuantityCheck(Map<String, Integer> menuMap, String menu, int quantity) {
        if (quantity < 0 || quantity > 20) {
            throw new UserInputException(ErrorMsg.ERROR_NOT_MENU.getMsg());
        }
    }
}
