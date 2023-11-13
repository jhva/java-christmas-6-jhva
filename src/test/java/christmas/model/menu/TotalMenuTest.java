package christmas.model.menu;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import christmas.constants.MenuType;
import christmas.model.DiscountMenu;
import christmas.model.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class TotalMenuTest {


    @ParameterizedTest
    @ArgumentsSource(MenuArgumentsProvider.class)
    void 할인_받기_전_메뉴_총합_금액(List<Menu> menus) {
        int totalPriceAmountExpected = 8500;

        int totalPriceAmount = menus.stream().mapToInt(Menu::getMenuPrice).sum();
        Assertions.assertEquals(totalPriceAmountExpected, totalPriceAmount);
    }


    @ParameterizedTest
    @ArgumentsSource(MenuArgumentsProviderTwo.class)
    void 메뉴_수량_만큼_할인_계산(List<Menu> menus) {
        List<DiscountMenu> discountMenus = new ArrayList<>();
        for (Menu menu : menus) {
            DiscountMenu discountMenu = new DiscountMenu(false, true, true,
                    menu.getMenuQuantity());
            discountMenus.add(discountMenu);
        }
        Assertions.assertEquals(8092, discountMenus.get(0).getWeekdayAmount());
        Assertions.assertEquals(1000, discountMenus.get(0).getSpecialAmount());
    }

    static class MenuArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            List<Arguments> arguments = new ArrayList<>();
            arguments.add(arguments(List.of(new Menu("코카콜라", 3000, MenuType.BEVERAGE.name(),
                            3),
                    new Menu("타파스", 5500, MenuType.APPETIZER.name(), 2))));
            return arguments.stream();
        }
    }

    static class MenuArgumentsProviderTwo implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            List<Arguments> arguments = new ArrayList<>();
            arguments.add(arguments(List.of(new Menu("티본스테이크", 55000, MenuType.MAIN.name(),
                            4),
                    new Menu("초코케이크", 15000, MenuType.APPETIZER.name(), 3))));
            return arguments.stream();
        }
    }
}
