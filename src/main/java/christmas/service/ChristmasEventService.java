package christmas.service;

import static christmas.constant.ChristmasConst.BAR;

import christmas.constant.ChristmasBenefits;
import christmas.constant.MenuType;
import christmas.dto.CalendarDto;
import christmas.dto.MenuDto;
import christmas.model.Menu;
import christmas.model.TotalDiscountMenu;
import christmas.model.TotalMenu;
import java.util.ArrayList;
import java.util.List;

public class ChristmasEventService {


    public void confirmCalendar(CalendarDto calendarDto) {
    }

    public List<MenuDto> createMenu(String[] menuParseWithRegex) {
        MenuType[] menuTypes = MenuType.values();
        List<Menu> menus = new ArrayList<>();

        for (String menu : menuParseWithRegex) {
            String[] menuNameAndCount = menu.split(BAR);
            processMenuTypes(menuTypes, menuNameAndCount, menus);
        }
        return convertMenusToDtos(menus);
    }

    private void processMenuTypes(MenuType[] menuTypes, String[] menuNameAndCount, List<Menu> menus) {
        String menuName = menuNameAndCount[0];
        String menuQuantity = menuNameAndCount[1];

        for (MenuType menuType : menuTypes) {
            int totalAmount = menuType.findMenuReturnTotalAmount(menuName, Integer.parseInt(menuQuantity));
            convertAmountToMenu(menuType, totalAmount, menuName, menuQuantity, menus);
        }
    }

    private void convertAmountToMenu(MenuType menuType, int totalAmount, String menuName, String menuQuantity,
            List<Menu> menus) {
        if (totalAmount > 0) {
            Menu menu = new Menu(menuName, totalAmount, menuType.name(), Integer.parseInt(menuQuantity));
            menus.add(menu);
        }
    }

    private List<MenuDto> convertMenusToDtos(List<Menu> menus) {
        List<MenuDto> menuDtos = new ArrayList<>();
        for (Menu menu : menus) {
            MenuDto menuDto = MenuDto.fromMenu(menu);
            menuDtos.add(menuDto);
        }
        return menuDtos;
    }

    public List<ChristmasBenefits> finderOfTotalMenuFromDiscount(CalendarDto calendar, TotalMenu menu,
            boolean isGivenChampagne) {
        List<ChristmasBenefits> allBenefits = new ArrayList<>();
        TotalDiscountMenu discountMenu = null;
        for (MenuDto menus : menu.getMenu()) {
            discountMenu = new TotalDiscountMenu(calendar.isWeekend(), calendar.isWeekday(), calendar.isSpecial(),
                    menus.menuQuantity(), isGivenChampagne, menus.menuType());
            validatorBenfits(discountMenu, isGivenChampagne, allBenefits, calendar.christmasCount());
        }
        return allBenefits;
    }

    public void validatorBenfits(TotalDiscountMenu totalDiscountMenu, boolean isGivenChampagne,
            List<ChristmasBenefits> allBenefits, int christmasDiscount) {
        ChristmasBenefits[] benefitsValue = ChristmasBenefits.values();
        for (ChristmasBenefits befits : benefitsValue) {
            befits.updateDiscountCounters(totalDiscountMenu, christmasDiscount);
            if (befits.getCounter() > 0 && !allBenefits.contains(befits)) {
                allBenefits.add(befits);
            }
        }
    }
}
