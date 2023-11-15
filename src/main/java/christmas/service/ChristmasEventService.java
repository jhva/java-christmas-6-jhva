package christmas.service;

import static christmas.constant.ChristmasConst.BAR;
import static christmas.constant.ChristmasConst.TARGET_ZERO;
import static christmas.constant.ChristmasConst.TOTAL_MENU_SIZE;
import static christmas.exception.Validator.validateMenuContains;

import christmas.constant.ChristmasBenefits;
import christmas.constant.MenuType;
import christmas.dto.CalendarDto;
import christmas.dto.MenuDto;
import christmas.exception.ErrorMsg;
import christmas.exception.UserInputException;
import christmas.model.Menu;
import christmas.model.TotalDiscountMenu;
import christmas.model.TotalMenu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ChristmasEventService {

    public List<MenuDto> createMenu(String[] menuParseWithRegex) {
        List<Menu> menus = new ArrayList<>();
        try {
            MenuType[] menuTypes = MenuType.values();
            Set<String> duplicateMenu = new HashSet<>();
            for (String menu : menuParseWithRegex) {
                String[] menuNameAndCount = menu.split(BAR);
                processMenuTypes(menuTypes, menuNameAndCount, menus, duplicateMenu);
            }
        } catch (UserInputException e) {
            System.out.println(e.getMessage());
        }
        return convertMenusToDtos(menus);
    }

    private void processMenuTypes(MenuType[] menuTypes, String[] menuNameAndCount, List<Menu> menus,
            Set<String> duplicate) {
        String menuName = menuNameAndCount[0];
        String menuQuantity = menuNameAndCount[1];
        validateMenuContains(duplicate, menuName);
        duplicate.add(menuName);
        totalAmountToMenu(menuTypes, menuName, menuQuantity, menus);
    }


    public void totalAmountToMenu(MenuType[] menuTypes, String menuName, String menuQuantity, List<Menu> menus) {
        for (MenuType menuType : menuTypes) {
            int totalAmount = menuType.findMenuReturnTotalAmount(menuName, Integer.parseInt(menuQuantity));
            convertAmountToMenu(menuType, totalAmount, menuName, menuQuantity, menus);
        }
    }

    private void convertAmountToMenu(MenuType menuType, int totalAmount, String menuName, String menuQuantity,
            List<Menu> menus) {
        if (totalAmount > TARGET_ZERO) {
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
        validTotalQuantityToTwenty(menuDtos);
        validateOrder(menuDtos);
        return menuDtos;
    }

    public void validTotalQuantityToTwenty(List<MenuDto> menuDtos) {
        int totalQuantity = menuDtos.stream()
                .mapToInt(MenuDto::menuQuantity)
                .sum();
        if (totalQuantity > TOTAL_MENU_SIZE) {
            throw new UserInputException(ErrorMsg.ERROR_NOT_MENU_SIZE.getMsg());
        }
    }

    public void validateOrder(List<MenuDto> menuDtos) {
        int drinkCount = (int) menuDtos.stream()
                .filter(menuDto -> Objects.equals(menuDto.menuType(), MenuType.BEVERAGE.name()))
                .count();
        int nonDrinkCount = menuDtos.size() - drinkCount;
        if (drinkCount > TARGET_ZERO && nonDrinkCount == TARGET_ZERO) {
            throw new UserInputException(ErrorMsg.ERROR_NOT_DRINK.getMsg());
        }
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
            if (befits.getCounter() > TARGET_ZERO && !allBenefits.contains(befits)) {
                allBenefits.add(befits);
            }
        }
    }
}
