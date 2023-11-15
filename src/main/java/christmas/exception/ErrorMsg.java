package christmas.exception;

public enum ErrorMsg {
    ERROR_NOT_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ERROR_NOT_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ERROR_NOT_NUMBER("[ERROR] 잘못된 입력입니다. 숫자를 입력하세요."),
    ERROR_NOT_MENU_SIZE("[ERROR] 메뉴의 총 개수 20개를 초과하였습니다. 다시 입력해 주세요"),
    ERROR_NOT_DRINK("[ERROR] 음료만 있는 주문은 처리할 수 없습니다. 다시 입력 해주세요.");
    private String msg;

    ErrorMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
