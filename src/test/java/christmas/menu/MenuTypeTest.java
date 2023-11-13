package christmas.menu;

import christmas.constants.MenuType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuTypeTest {

    @Test
    void 받아온_input_으로부터_메뉴에_있는지_확인한다() {
        MenuType[] menuTypes = MenuType.values();
        String input = "아이스크림";
        boolean isMenuFound = false;
        for (MenuType menuType : menuTypes) {
            isMenuFound = menuType.findMenu(input);
            if (isMenuFound) {
                break;
            }
        }
        Assertions.assertTrue(isMenuFound);
    }
}
