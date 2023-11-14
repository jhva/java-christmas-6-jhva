package christmas.model;

import christmas.dto.MenuDto;
import java.util.Collections;
import java.util.List;

public class TotalMenu {

    private final List<MenuDto> menuDto;

    public TotalMenu(List<MenuDto> menuDto) {
        this.menuDto = menuDto;
    }

    public int selectedViewMenuReturnTotalPrice() {
        return menuDto.stream().mapToInt(MenuDto::menuPrice).sum();
    }

    public boolean isTotalAmountSufficient(int totalPrice) {
        return totalPrice >= 120000;
    }

    public List<MenuDto> getMenu() {
        return Collections.unmodifiableList(menuDto);
    }
}
