package christmas.exception;


import static christmas.constant.ChristmasConst.CHRISTMAS_DAY;
import static christmas.constant.ChristmasConst.START_MSG;
import static christmas.view.OutView.printException;

import camp.nextstep.edu.missionutils.Console;

public class Validator {

    private static final int MAX_DAY = 31;
    private static final String RETRY_MSG = "26일 이후 부터는 크리스마스 혜택을 받을 수 없습니다. 진행하시겠습니까?\n1.계속 2.돌아가기";
    private static final int EXIT = 2;
    private static final int CONTINUE = 1;

    public static int validateDay(int day) throws UserInputException {
        while (day <= 0 || day > MAX_DAY) {
            printException(ErrorMsg.ERROR_NOT_DATE.getMsg());
            day = Integer.parseInt(Console.readLine());
        }
        retryStart(day);
        return day;
    }

    public static void retryStart(int day) {
        if (day > CHRISTMAS_DAY && day < MAX_DAY) {
            printException(RETRY_MSG);
            int retryNumber = Integer.parseInt(Console.readLine());
            if (retryNumber != CONTINUE && retryNumber != EXIT) {
                printException(ErrorMsg.ERROR_NOT_DATE.getMsg());
                retryStart(day);
            }
            retryStartValidateDay(retryNumber);
        }
    }

    public static void retryStartValidateDay(int retryNumber) {
        if (retryNumber == EXIT) {
            System.out.println(START_MSG);
            validateDay(Integer.parseInt(Console.readLine()));
        }
    }
}

