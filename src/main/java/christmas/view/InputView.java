package christmas.view;


import camp.nextstep.edu.missionutils.Console;
import christmas.exception.ErrorMsg;

public class InputView {

    public String commonMenuInput() {
        return Console.readLine();
    }

    public int commonIntegerInput() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println(ErrorMsg.ERROR_NOT_NUMBER.getMsg());
        }
        return Integer.parseInt(Console.readLine());
    }
}
