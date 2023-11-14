package christmas.model;

import static christmas.utils.ChristmasAppUtils.formatPrice;

import christmas.dto.MenuDto;
import java.util.Collections;
import java.util.List;

public class TotalMenu {

    private final List<MenuDto> menuDto;

    public TotalMenu(List<MenuDto> menuDto) {
        this.menuDto = menuDto;
    }

    public String selectedViewMenuReturnTotalPrice() {
        return formatPrice(menuDto.stream().mapToInt(MenuDto::menuPrice).sum());
    }

    public boolean isTotalAmountSufficient(int totalPrice) {
        return totalPrice >= 120000;
    }

    public List<MenuDto> getMenu() {
        return Collections.unmodifiableList(menuDto);
    }
}
