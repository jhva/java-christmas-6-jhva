package christmas.exception;

public enum ErrorMsg {
    ERROR_NOT_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    private String msg;

    ErrorMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
