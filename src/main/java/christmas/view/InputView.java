package christmas.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String commonMenuInput() {
        return Console.readLine();
    }

    public int commonIntegerInput() {
        return Integer.parseInt(Console.readLine());
    }
}
