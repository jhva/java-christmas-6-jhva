package christmas.controller;

import static christmas.constant.ChristmasConst.COMMA;
import static christmas.utils.ChristmasAppUtils.splitByRegex;

import christmas.dto.CalendarDto;
import christmas.dto.MenuDto;
import christmas.model.Calendar;
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
        outView.starterViewMsg();
        CalendarDto calendar = reservationVisitDay();
        List<MenuDto> menu = menuSelector();
    }

    private List<MenuDto> menuSelector() {
        outView.menuViewMsg();
        String menu = inputView.commonMenuInput();
        String[] menuParseWithRegex = splitByRegex(menu, COMMA);
        List<MenuDto> menuDto = christmasEventService.createMenu(menuParseWithRegex);
        return menuDto;
    }

    private CalendarDto reservationVisitDay() {
        int day = inputView.commonIntegerInput();
        Calendar calendar = new Calendar(day);
        CalendarDto calendarDto = CalendarDto.fromCalendar(calendar);
        christmasEventService.confirmCalendar(calendarDto);
        return calendarDto;
    }
}
