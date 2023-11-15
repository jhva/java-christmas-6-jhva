package christmas.exception;


import static christmas.constant.ChristmasConst.COMMA;
import static christmas.constant.ChristmasConst.TARGET_ZERO;
import static christmas.view.OutView.printException;

import camp.nextstep.edu.missionutils.Console;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final int MAX_DAY = 31;
    private static final String RETRY_MSG = "26일 이후 부터는 크리스마스 혜택을 받을 수 없습니다. 진행하시겠습니까?\n1.계속 2.돌아가기";
    private static final int EXIT = 2;
    private static final int CONTINUE = 1;
    private static final String INTEGER_PATTERN = "\\d+";
    private static final String MENU_FORM_PATTERN = "^[ㄱ-ㅎㅏ-ㅣ가-힣A-Za-z]+-\\d+$";

    public static int validateDay(int day) {
        while (day <= TARGET_ZERO || day > MAX_DAY) {
            printException(ErrorMsg.ERROR_NOT_DATE.getMsg());
            day = Integer.parseInt(Console.readLine());
        }
        return day;
    }


    public static String[] validateMenuCheckReturnMenu(String menu) {
        String[] menuItems = menu.split(COMMA);
        try {
            return menuMatcher(menuItems);
        } catch (UserInputException e) {
            System.out.println(e.getMessage());
            validateMenuCheckReturnMenu(Console.readLine());
        }
        return menuItems;
    }

    public static String[] menuMatcher(String[] menu) {
        for (String menuItem : menu) {
            Pattern menuPattern = Pattern.compile(MENU_FORM_PATTERN);
            Matcher menuMatcher = menuPattern.matcher(menuItem.trim());
            if (!menuMatcher.matches()) {
                throw new UserInputException(ErrorMsg.ERROR_NOT_MENU.getMsg());
            }
        }
        return menu;
    }

    public static void validateMenuContains(Set<String> duplicate, String menuName) {
        if (duplicate.contains(menuName)) {
            throw new UserInputException(ErrorMsg.ERROR_NOT_MENU.getMsg());
        }
    }

    public static void validatorQuantity(String quantity) {
        if (!quantity.matches(INTEGER_PATTERN)) {
            throw new UserInputException(ErrorMsg.ERROR_NOT_MENU.getMsg());
        }
    }
}

