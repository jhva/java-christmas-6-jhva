package christmas.controller;

import static christmas.constant.ChristmasConst.COMMA;
import static christmas.constant.ChristmasConst.SELECT_MENU_NAME_QUANTITY;
import static christmas.utils.ChristmasAppUtils.formatPrice;
import static christmas.utils.ChristmasAppUtils.splitByRegex;

import christmas.constant.ChristmasBadge;
import christmas.constant.ChristmasBenefits;
import christmas.dto.CalendarDto;
import christmas.dto.MenuDto;
import christmas.model.Calendar;
import christmas.model.ChristmasBenefitsDetails;
import christmas.model.TotalMenu;
import christmas.service.ChristmasEventService;
import christmas.view.InputView;
import christmas.view.OutView;
import java.util.List;

public class ChristmasEventController {

    private final InputView inputView;
    private final OutView outView;
    private final ChristmasEventService christmasEventService;

    public ChristmasEventController(InputView inputView, OutView outView) {
        this.inputView = inputView;
        this.outView = outView;
        this.christmasEventService = new ChristmasEventService();
    }

    public void run() {
        CalendarDto calendar = reservationVisitDay();
        TotalMenu menu = menuSelector();
        int totalAmount = totalAmountAndSelectedMenu(menu);
        boolean isGivenChampagne = menu.isTotalAmountSufficient(totalAmount);
        givenChampagne(isGivenChampagne);
        List<ChristmasBenefits> totalDiscountMenu = christmasEventService.finderOfTotalMenuFromDiscount(calendar, menu,
                isGivenChampagne);
        ChristmasBenefitsDetails benefitsDetails = new ChristmasBenefitsDetails(totalDiscountMenu);
        totalDiscountMenuCheck(benefitsDetails, calendar.christmasCount());
        int benefitAmount = benefitsDetails.calculateTotalBenefits();
        eventParticipationBadge(benefitAmount);

    }

    private void givenChampagne(boolean isGivenChampagne) {
        outView.giveawayMenuMsg();
        if (!isGivenChampagne) {
            outView.nothingMsg();
            return;
        }
        outView.selectedMenuMsg(SELECT_MENU_NAME_QUANTITY, 1);
    }


    private TotalMenu menuSelector() {
        outView.menuViewMsg();
        String menu = inputView.commonMenuInput();
        String[] menuParseWithRegex = splitByRegex(menu, COMMA);
        List<MenuDto> menuDto = christmasEventService.createMenu(menuParseWithRegex);
        return new TotalMenu(menuDto);
    }

    private CalendarDto reservationVisitDay() {
        outView.starterViewMsg();
        int day = inputView.commonIntegerInput();
        Calendar calendar = new Calendar(day);
        CalendarDto calendarDto = CalendarDto.fromCalendar(calendar);
        christmasEventService.confirmCalendar(calendarDto); //예외 ?
        return calendarDto;
    }


    public int totalAmountAndSelectedMenu(TotalMenu totalMenu) {
        outView.beforeOrderingMsg();
        selectedMenu(totalMenu);
        System.out.println();
        outView.totalOrderAmountBeforeDiscountMsg();
        int totalAmount = totalMenu.selectedViewMenuReturnTotalPrice();
        outView.numberTotalPriceFormatWonMsg(formatPrice(totalAmount));
        return totalAmount;
    }

    public void selectedMenu(TotalMenu totalMenu) {
        for (MenuDto menu : totalMenu.getMenu()) {
            outView.selectedMenuMsg(menu.menuName(), menu.menuQuantity());
        }
    }

    private void totalDiscountMenuCheck(ChristmasBenefitsDetails benefitsDetails, int christmasDiscount) {
        outView.benefitsDetailsMsg();
//        benefitsDetails.test();
    }

    public void eventParticipationBadge(int benefitAmount) {
        String badge = ChristmasBadge.getBadge(benefitAmount);
        outView.eventBadgeMsg();
        System.out.println(badge);
    }
}
