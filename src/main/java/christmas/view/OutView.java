package christmas.view;

import static christmas.constant.ChristmasConst.BEFORE_DISCOUNT_MSG;
import static christmas.constant.ChristmasConst.BEFORE_ORDER_MSG;
import static christmas.constant.ChristmasConst.BENEFITS_DETAILS_MSG;
import static christmas.constant.ChristmasConst.EVENT_BADGE_MSG;
import static christmas.constant.ChristmasConst.EVENT_BENEFITS_MSG;
import static christmas.constant.ChristmasConst.GIVEAWAY_MENU_MSG;
import static christmas.constant.ChristmasConst.MENU_VIEW_MSG;
import static christmas.constant.ChristmasConst.SELECT_MENU_NAME_QUANTITY;
import static christmas.constant.ChristmasConst.START_MSG;
import static christmas.constant.ChristmasConst.TOTAL_AMOUNT_AFTER_DISCOUNT_MSG;
import static christmas.constant.ChristmasConst.TOTAL_BENEFITS_AMOUNT_MSG;


public class OutView {

    public void starterViewMsg() {
        System.out.println(START_MSG);
    }

    public void menuViewMsg() {
        System.out.println(MENU_VIEW_MSG);
    }

    public void selectedMenuMsg(String menuName, int menuQuantity) {
        String selectMenu = String.format(SELECT_MENU_NAME_QUANTITY, menuName, menuQuantity);
        System.out.println(selectMenu);
    }

    public void beforeOrderingMsg() {
        System.out.println(EVENT_BENEFITS_MSG);
        System.out.println(BEFORE_ORDER_MSG);
    }

    public void totalOrderAmountBeforeDiscountMsg() {
        System.out.println(BEFORE_DISCOUNT_MSG);
    }

    public void giveawayMenuMsg() {
        System.out.println(GIVEAWAY_MENU_MSG);
    }

    public void benefitsDetailsMsg() {
        System.out.println(BENEFITS_DETAILS_MSG);
    }

    public void totalBenefitsAmountMsg() {
        System.out.println(TOTAL_BENEFITS_AMOUNT_MSG);
    }

    public void totalAmountAfterDiscountMsg() {
        System.out.println(TOTAL_AMOUNT_AFTER_DISCOUNT_MSG);
    }

    public void eventBadgeMsg() {
        System.out.println(EVENT_BADGE_MSG);
    }
}
