package christmas.controller;

import static christmas.constant.ChristmasConst.DEFAULT_CHAMPAGNE_AMOUNT;
import static christmas.constant.ChristmasConst.TARGET_ZERO;
import static christmas.exception.Validator.validateMenuCheckReturnMenu;
import static christmas.utils.ChristmasAppUtils.formatPrice;

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
        outView.giveawayMenuMsg(isGivenChampagne);
        ChristmasBenefitsDetails benefitsDetails = new ChristmasBenefitsDetails(
                christmasEventService.finderOfTotalMenuFromDiscount(calendar, menu, isGivenChampagne));
        totalDiscountMenuCheck(benefitsDetails, calendar.christmasCount());
        totalAmountAndBadge(benefitsDetails, totalAmount, isGivenChampagne);
    }

    private TotalMenu menuSelector() {
        outView.menuViewMsg();
        String[] menu = validateMenuCheckReturnMenu(inputView.commonMenuInput());
        List<MenuDto> menuDto = christmasEventService.createMenu(menu);
        return new TotalMenu(menuDto);
    }

    private CalendarDto reservationVisitDay() {
        outView.starterViewMsg();
        int day = inputView.commonIntegerInput();
        Calendar calendar = new Calendar(day);
        return CalendarDto.fromCalendar(calendar);
    }


    public int totalAmountAndSelectedMenu(TotalMenu totalMenu) {
        outView.beforeOrderingMsg();
        selectedMenu(totalMenu);
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

    public void totalAmountAndBadge(ChristmasBenefitsDetails benefitsDetails, int totalAmount,
            boolean isGivenChampagne) {
        int benefitAmount = benefitsDetails.calculateTotalBenefits();
        int expectedAmount = benefitsDetails.calculateTotalBenefits();
        outView.totalBenefitsAmountMsg();
        outView.discountPriceFormatMsg(formatPrice(benefitAmount));
        if (isGivenChampagne) {
            expectedAmount -= DEFAULT_CHAMPAGNE_AMOUNT;
        }
        outView.totalAmountAfterDiscountMsg(totalAmount, expectedAmount);
        outView.eventBadgeMsg(benefitAmount);
    }

    private void totalDiscountMenuCheck(ChristmasBenefitsDetails benefitsDetails, int christmasDiscount) {
        List<ChristmasBenefits> benefits = benefitsDetails.getBenefits();
        outView.benefitsDetailsMsg();
        if (benefits.size() == TARGET_ZERO) {
            outView.nothingMsg();
        }
        for (ChristmasBenefits benefit : benefitsDetails.getBenefits()) {
            System.out.println(String.format(benefit.getMessage(), formatPrice(benefit.getPrice())));
        }
    }
}
