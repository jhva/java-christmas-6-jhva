package christmas.model.menu;

import christmas.constants.MenuType;
import christmas.model.Menu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuTest {

    @ParameterizedTest
    @ValueSource(strings = {"타파스-1,제로콜라-1"})
    void 주문한_메뉴가_있을_경우_개수_만큼_합산_한다(String input) {
        String[] inputEachMenu = input.split(",");
        System.out.println(Arrays.toString(inputEachMenu));
        MenuType[] menuTypes = MenuType.values();
        List<Menu> menus = new ArrayList<>();
        for (String menu : inputEachMenu) {
            String[] menuNameAndCount = menu.split("-");
            String menuName = menuNameAndCount[0];
            String menuQuantity = menuNameAndCount[1];
            for (MenuType menuType : menuTypes) {
                int totalAmount = menuType.findMenuReturnTotalAmount(menuName, Integer.parseInt(menuQuantity));
                if (totalAmount > 0) {
                    menus.add(new Menu(menuName, totalAmount, menuType.name(), Integer.parseInt(menuQuantity)));
                }
            }
        }
        int TAPAS_PRICE = 5500;
        int ZERO_COLA_PRICE = 3000;
        Assertions.assertEquals(menus.size(), 2);
        Assertions.assertEquals(menus.get(0).getMenuPrice(), TAPAS_PRICE);
        Assertions.assertEquals(menus.get(0).getMenuType(), MenuType.APPETIZER.name());
        Assertions.assertEquals(menus.get(1).getMenuType(), MenuType.BEVERAGE.name());
        Assertions.assertEquals(menus.get(1).getMenuPrice(), ZERO_COLA_PRICE);
    }
}
