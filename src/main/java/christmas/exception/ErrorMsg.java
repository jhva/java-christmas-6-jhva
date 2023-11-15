package christmas.exception;

public enum ErrorMsg {
    ERROR_NOT_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ERROR_NOT_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ERROR_NOT_NUMBER("잘못된 입력입니다. 숫자를 입력하세요."),
    ERROR_NOT_VALID_FORM("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private String msg;

    ErrorMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
