package christmas.menu;

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
            String menuCount = menuNameAndCount[1];
            for (MenuType menuType : menuTypes) {
                int count = menuType.findMenu(menuName, Integer.parseInt(menuCount));
                if (count > 0) {
                    menus.add(new Menu(menuName, count, menuType));
                }
            }
        }
        Assertions.assertEquals(menus.size(), 2);
        Assertions.assertEquals(menus.get(0).getMenuPrice(), 5500);
        Assertions.assertEquals(menus.get(1).getMenuPrice(), 3000);
    }
}
