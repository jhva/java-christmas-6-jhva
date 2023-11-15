package christmas.exception;


import static christmas.view.OutView.printException;

import camp.nextstep.edu.missionutils.Console;

public class Validator {

    private static final int MAX_DAY = 31;

    public static int validateDay(int day) {
        while (day <= 0 || day > MAX_DAY) {
            try {
                day = Integer.parseInt(Console.readLine());
            } catch (UserInputException ex) {
                printException(ErrorMsg.ERROR_NOT_DATE.getMsg());
            }
        }
        return day;
    }
}

