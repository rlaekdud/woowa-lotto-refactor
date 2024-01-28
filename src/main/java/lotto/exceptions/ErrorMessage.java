package lotto.exceptions;

public enum ErrorMessage {
    NUM_OUT_OF_RANGE("[ERROR] 로또 숫자의 범위는 1~45여야 합니다."),
    DUPLICATED_NUM("[ERROR] 로또 숫자는 중복되지 않아야 합니다."),
    INVALID_NUM_COUNT("[ERROR] 로또 숫자는 6개여야 합니다."),
    NOT_NUM_INPUT("[ERROR] 입력 형식이 올바르지 않습니다."),
    CANNOT_DIVIDE_BY_THOUSAND("[ERROR] 구입금액은 1000원 단위로 입력되어야 합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
