package christmas.view;

import static christmas.constant.ChristmasConst.BEFORE_DISCOUNT_MSG;
import static christmas.constant.ChristmasConst.BEFORE_ORDER_MSG;
import static christmas.constant.ChristmasConst.BENEFITS_DETAILS_MSG;
import static christmas.constant.ChristmasConst.COMMA;
import static christmas.constant.ChristmasConst.DISCOUNT_WON;
import static christmas.constant.ChristmasConst.EVENT_BADGE_MSG;
import static christmas.constant.ChristmasConst.EVENT_BENEFITS_MSG;
import static christmas.constant.ChristmasConst.GIVEAWAY_MENU_MSG;
import static christmas.constant.ChristmasConst.MENU_VIEW_MSG;
import static christmas.constant.ChristmasConst.NOTHING_MSG;
import static christmas.constant.ChristmasConst.SELECT_MENU_NAME_QUANTITY;
import static christmas.constant.ChristmasConst.START_MSG;
import static christmas.constant.ChristmasConst.TARGET_ZERO;
import static christmas.constant.ChristmasConst.TOTAL_AMOUNT_AFTER_DISCOUNT_MSG;
import static christmas.constant.ChristmasConst.TOTAL_BENEFITS_AMOUNT_MSG;
import static christmas.constant.ChristmasConst.WON;
import static christmas.utils.ChristmasAppUtils.formatPrice;

import christmas.constant.ChristmasBadge;


public class OutView {

    private static final String CHAMPAGNE = "샴페인";
    private static final String REPLACE_BLANK = "";

    private static final int QUANTITY = 1;

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

    public void numberTotalPriceFormatWonMsg(String price) {
        String msg = String.format(WON, price);
        System.out.println(msg);
    }

    public void discountPriceFormatMsg(String price) {
        String replaceParser = price.replace(COMMA, REPLACE_BLANK);
        if (Integer.parseInt(replaceParser) == TARGET_ZERO) {
            nothingMsg();
            return;
        }
        String msg = String.format(DISCOUNT_WON, price);
        System.out.println(msg);
    }

    public void beforeOrderingMsg() {
        System.out.println(EVENT_BENEFITS_MSG);
        System.out.println(BEFORE_ORDER_MSG);
    }

    public void nothingMsg() {
        System.out.println(NOTHING_MSG);
    }

    public void totalOrderAmountBeforeDiscountMsg() {
        System.out.println();
        System.out.println(BEFORE_DISCOUNT_MSG);
    }

    public void giveawayMenuMsg(boolean isGivenChampagne) {
        System.out.println();
        System.out.println(GIVEAWAY_MENU_MSG);
        if (!isGivenChampagne) {
            nothingMsg();
            return;
        }
        selectedMenuMsg(CHAMPAGNE, QUANTITY);
    }

    public void benefitsDetailsMsg() {
        System.out.println();
        System.out.println(BENEFITS_DETAILS_MSG);
    }

    public void totalBenefitsAmountMsg() {
        System.out.println();
        System.out.println(TOTAL_BENEFITS_AMOUNT_MSG);
    }

    public void totalAmountAfterDiscountMsg(int totalAmount, int discountAmount) {
        System.out.println();
        System.out.println(TOTAL_AMOUNT_AFTER_DISCOUNT_MSG);
        System.out.printf(String.format(WON, formatPrice(totalAmount - discountAmount)));
        System.out.println();
    }

    public void eventBadgeMsg(int benefitAmount) {
        System.out.println();
        System.out.println(EVENT_BADGE_MSG);
        String badge = ChristmasBadge.getBadge(benefitAmount);
        System.out.print(badge);
    }
}
