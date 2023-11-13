package christmas.model.menu;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import christmas.constants.MenuType;
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

    static class MenuArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            List<Arguments> arguments = new ArrayList<>();
            arguments.add(arguments(List.of(new Menu("코카콜라", 3000, MenuType.BEVERAGE.name()),
                    new Menu("타파스", 5500, MenuType.APPETIZER.name()))));
            return arguments.stream();
        }
    }
}
