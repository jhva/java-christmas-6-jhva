package christmas.exception;


import static christmas.view.OutView.printException;

import camp.nextstep.edu.missionutils.Console;

public class Validator {

    private static final int MAX_DAY = 31;

    public static int validateDay(int day) throws UserInputException {
        while (day <= 0 || day > MAX_DAY) {
            printException(ErrorMsg.ERROR_NOT_DATE.getMsg());
            day = Integer.parseInt(Console.readLine());
        }
        return day;
    }
}

